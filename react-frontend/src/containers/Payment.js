import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Container from '@mui/material/Container'
import Paper from '@mui/material/Paper'
import Button from '@mui/material/Button'
import { useState, useEffect } from 'react';
import { theatreSelected } from "./Theatres.js";
import { movieSelected } from "./Movies.js";
import { stSelected } from "./Showtimes.js";

export default function Payment() {
  const paperStyle = {padding:'50px 20px', width:600, margin:'20px auto'}
  const [isError, setIsError] = useState(false);
  const [isSubmitted, setIsSubmitted] = useState(false);
  const [cardNo,setCardNo] = useState('')
  const [expiry,setExpiry] = useState('')
  const [cvv,setCvv] = useState('')
  const [name,setName] = useState('')

  const handleClick=(e)=>{
    e.preventDefault()
    const creditCard={cardNo, expiry, cvv, name}
    console.log(creditCard)
    // TODO: send data to database
    fetch("http://localhost:8080/api/v1/payment", 
    {
      method:"PUT",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(creditCard)
    }).then(()=>{
      console.log("Payment Successful")
      setIsSubmitted(true);
      setIsError(false);
    }).catch(()=>{
      console.log("Error")
      setIsError(true);
      setIsSubmitted(false);
    })
  }

  return (
    <Container>
      <Paper elevation={3} style={paperStyle}>
      <h1>Ticket</h1>
        
          <Paper elevation={6} style={{margin:"10px",padding:"15px",textAlign:"left"}}>
            Theatre:{theatreSelected.name},
            Movie:{movieSelected.name},
            Showtime:{stSelected.showtime}
          </Paper>
      
      </Paper>

      <Paper elevation={3} style={paperStyle}>
        <h1>Payment</h1>
        <p>Your total is $8.00</p>

    <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 1, width: 500, maxWidth: '100%' },
      }}
      noValidate
      autoComplete="off"
    >
      <TextField required id="outlined-required" label="Credit Card Number" variant="outlined" fullWidth
      value = {cardNo}
      onChange={(e)=>setCardNo(e.target.value)}
      />
      <TextField required id="outlined-required" label="Expiry Date (MM/YY)" variant="outlined" fullWidth
      value = {expiry}
      onChange={(e)=>setExpiry(e.target.value)}
      />
      <TextField required id="outlined-required" label="CVV" variant="outlined" fullWidth
      value = {cvv}
      onChange={(e)=>setCvv(e.target.value)}
      />
      <TextField required id="outlined-required" label="Cardholder Name" variant="outlined" fullWidth
      value = {name}
      onChange={(e)=>setName(e.target.value)}
      />
      
      <Button variant="contained" onClick={handleClick}>
        Submit
      </Button>
    </Box>
    </Paper>

      <Paper elevation={3} style={paperStyle}>
        <h1>Response</h1>
        {isSubmitted ? <div>Payment Successful! Please check your email.</div> : 
                        <div></div>}
        {isError ? <div>Error. Please try again.</div> : 
                        <div></div>}
      </Paper>
    </Container>
  );
}
