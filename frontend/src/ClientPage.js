import React, {Component} from "react";
import {Button, ButtonGroup, Pagination, PaginationItem, PaginationLink} from "reactstrap";
import {Link} from "react-router-dom";
import AppNavbar from "./AppNavbar";


class ClientPage extends Component {
  constructor(props) {
    super(props);
    this.state = {clients: [], page: 1, size: 10, totalPages: 0};
    this.remove = this.remove.bind(this);
    this.handleClick = this.handleClick.bind(this);
  }

  componentDidMount() {
    fetch(`/clients/page?page=${this.state.page}&size=${this.state.size}`)
      .then(response => response.json())
      .then(data => this.setState({
        clients: data.content,
        page: data.pageable.pageNumber + 1,
        size: data.pageable.pageSize,
        totalPages: data.totalPages
      }));
  }

  handleClick(e, index) {
    console.log('index', index)
    e.preventDefault();
    fetch(`/clients/page?page=${index}&size=${this.state.size}`)
      .then(response => response.json())
      .then(data => this.setState({
        clients: data.content,
        page: data.pageable.pageNumber + 1,
        size: data.pageable.pageSize,
        totalPages: data.totalPages
      }));
  }


  async remove(id) {
    await fetch(`/clients/${id}`, {
      method: 'DELETE',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    }).then(() => {
      let updatedClients = [...this.state.clients].filter(i => i.id !== id);
      this.setState({clients: updatedClients});
    });
  }


  render() {
    const {clients, page, size, totalPages} = this.state;
    console.log('page:', page, 'size:', size, 'totalPages:', totalPages)

    const clientPage = clients.map(client => {

      return <tr key={client.id}>
        <th scope={"row"}>{client.id}</th>
        <td>{client.name}</td>
        <td>{client.email}</td>
        <td>
          <ButtonGroup>
            <Button size="sm" color="primary" tag={Link} to={"/clients/" + client.id}>Edit</Button>
            <Button size="sm" color="danger" onClick={() => this.remove(client.id)}>Delete</Button>
          </ButtonGroup>
        </td>
      </tr>
    });

    const pageNumbers = Array.from({length: totalPages}, (_, index) => (
      <PaginationItem key={index} active={index === page - 1}>
        <PaginationLink onClick={(e) => this.handleClick(e, index + 1)} href="#">
          {index + 1}
        </PaginationLink>
      </PaginationItem>
    ));

    return (
      <div>
        <AppNavbar/>

        <h1>Client Page</h1>
        <div className="flex-container">
          <Button color="success" tag={Link} to="/clients/new" >Add Client</Button>
        </div>
        <table className="table">
          <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Action</th>
          </tr>
          </thead>
          <tbody>
          {clientPage}
          </tbody>
        </table>
        <div className="flex-container">
          <Pagination>
            <PaginationItem disabled={page === 1}>
              <PaginationLink first href="#" onClick={(e) => this.handleClick(e, 1)}/>
            </PaginationItem>
            <PaginationItem disabled={page === 1}>
              <PaginationLink previous href="#" onClick={(e) => this.handleClick(e, page - 1)}/>
            </PaginationItem>
            {pageNumbers}
            <PaginationItem disabled={page === totalPages}>
              <PaginationLink next href="#" onClick={(e) => this.handleClick(e, page + 1)}/>
            </PaginationItem>
            <PaginationItem disabled={page === totalPages}>
              <PaginationLink last href="#" onClick={(e) => this.handleClick(e, totalPages)}/>
            </PaginationItem>
          </Pagination>
        </div>
      </div>
    );
  }
}

export default ClientPage;
