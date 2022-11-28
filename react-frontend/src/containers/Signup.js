import React, { useState } from "react";
import { useAppContext } from "../lib/contextLib";
import { useNavigate } from "react-router-dom";
import Button from '@mui/material/Button';
import "./Signup.css";

export default function Signup() {
  const nav = useNavigate();

  // React States
  const [errorMessages, setErrorMessages] = useState({});
  const [isSubmitted, setIsSubmitted] = useState(false);
  const { userHasAuthenticated } = useAppContext();

  // User Login info
  const database = [
    {
      username: "user",
      password: "pass"
    }
  ];

  const errors = {
    uname: "invalid username",
    pass: "invalid password"
  };

  const handleSubmit = (event) => {
      //Prevent page reload
      event.preventDefault();

      var { uname, pass } = document.forms[0];

      // Find user login info
      const userData = database.find((user) => user.username === uname.value);

      // Compare user info
      if (userData) {
        if (userData.password !== pass.value) {
          // Invalid password
          setErrorMessages({ name: "pass", message: errors.pass });
        } else {
          setIsSubmitted(true);
          userHasAuthenticated(true)
          nav("/movie-ticket-system/");
        }
      } else {
        // Username not found
        setErrorMessages({ name: "uname", message: errors.uname });
      }
  };

  // Generate JSX code for error message
  const renderErrorMessage = (name) =>
    name === errorMessages.name && (
      <div className="error">{errorMessages.message}</div>
  );

  // JSX code for login form
  const renderForm = (
    <div className="form">
      <form onSubmit={handleSubmit}>
        <div className="input-container">
          <label>Email Address </label>
          <input type="text" name="uname" required />
          {renderErrorMessage("uname")}
        </div>
        <div className="input-container">
          <label>Password </label>
          <input type="password" name="pass" required />
          {renderErrorMessage("pass")}
        </div>
        <div className="button-container">
        <Button variant="contained" onClick={handleSubmit}>
          Submit
        </Button>
        </div>
      </form>
    </div>
  );

  return (
    <div className="app">
      <div className="login-form">
        <div className="title">Sign Up</div>
        {isSubmitted ? <div>User is successfully signed up</div> : renderForm}
      </div>
    </div>
  );
}