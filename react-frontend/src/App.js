import React, { useState } from "react";

import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import { LinkContainer } from "react-router-bootstrap";

import Routes from "./Routes";
import { AppContext } from "./lib/contextLib";
import { useNavigate } from "react-router-dom";

import "./App.css";

function App() {
  const nav = useNavigate();
  const [isAuthenticated, userHasAuthenticated] = useState(false);
  const [isuserType, userType] = useState(false);

  function handleLogout() {
    userHasAuthenticated(false);
    nav("/movie-ticket-system/");
  }

  return (
    <div className="App container py-3">
      <Navbar collapseOnSelect bg="light" expand="md" className="mb-3">
        {isAuthenticated ? (
            <LinkContainer to="/movie-ticket-system/theatres">
            <Navbar.Brand className="font-weight-bold text-muted">
              Movie Ticket System
            </Navbar.Brand>
          </LinkContainer>
          ) : (
            <Navbar.Brand className="font-weight-bold text-muted">
              Movie Ticket System
            </Navbar.Brand>
          )}
          
        <Navbar.Toggle />
        <Navbar.Collapse className="justify-content-end">
          <Nav activeKey={window.location.pathname}>
          {isAuthenticated ? ( 
              <>
                <LinkContainer to="/movie-ticket-system/account">
                  <Nav.Link>Account</Nav.Link>
                </LinkContainer>
                <Nav.Link onClick={handleLogout}>Logout</Nav.Link>
              </>
          ) : (
            <>
              <LinkContainer to="/movie-ticket-system/signup">
                <Nav.Link>Sign Up</Nav.Link>
              </LinkContainer>
              <LinkContainer to="/movie-ticket-system/">
                <Nav.Link>Login</Nav.Link>
              </LinkContainer>
              <LinkContainer to="/movie-ticket-system/adminLogin">
                <Nav.Link>Admin Login</Nav.Link>
              </LinkContainer>
            </>
          )}
          </Nav>
        </Navbar.Collapse>
      </Navbar>
      <AppContext.Provider value={{ isAuthenticated, userHasAuthenticated, 
                                    isuserType, userType}}>
        <Routes />
      </AppContext.Provider>
    </div>
  );
}

export default App;
