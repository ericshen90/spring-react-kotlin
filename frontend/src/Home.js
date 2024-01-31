import React, {Component} from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import {Link} from 'react-router-dom';
import {Button, Container} from 'reactstrap';

class Home extends Component {
  render() {
    return (
      <div>
        <AppNavbar/>
        <Container fluid>
          <div className="float-right" >
            {/*<Button color="info" tag={Link} to="/clients">Clients</Button>*/}
            <Button color="info" tag={Link} to="/clientPage">ClientPage</Button>
          </div>
        </Container>
      </div>
    );
  }
}

export default Home;
