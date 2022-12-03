import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Container from '@mui/material/Container'
import Paper from '@mui/material/Paper'
import Button from '@mui/material/Button'
import { useState, useEffect } from 'react';
import { userInfo } from "./Login.js";
var totalPrice = 0.00;


export default function Payment() {
  const paperStyle = {padding:'50px 20px', width:600, margin:'20px auto'}
  const [isError, setIsError] = useState(false);
  const [isSubmitted, setIsSubmitted] = useState(false);
  const [cardNo,setCardNo] = useState('')
  const [expiry,setExpiry] = useState('')
  const [cvv,setCvv] = useState('')
  const [name,setName] = useState('')

  const [tickets,setTickets] = useState([])

  function sortByKey(array, key) {
		return array.sort(function (a, b) {
			var x = Number(a[key]);
			var y = Number(b[key]);
			return x < y ? -1 : x > y ? 1 : 0;
		});
	}

  useEffect(()=>{
    fetch("http://localhost:8080/api/v1/registereduser/tickets"+userInfo.email)
    .then(res=>res.json())
    .then(result=>{
      setTickets(sortByKey(JSON.parse(JSON.stringify(result)), "id"));
    })
  },[])

  useEffect(()=>{
    totalPrice = tickets.length * 10;
    console.log(tickets.length);
  },[tickets]) 

  const handleClick=(e)=>{
    e.preventDefault()
    const creditCard={cardNo, expiry, cvv, name}
    console.log(creditCard)
    // TODO: send data to database
    fetch("http://localhost:8080/api/v1/payment/addPayment", 
    {
      method:"POST",
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

  const handleClick2=(e)=>{
    e.preventDefault()
    fetch("http://localhost:8080/seat/reserveSeat", 
    {
      method:"PUT",
      headers:{"Content-Type":"application/json"},
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
      <h1>Ticket Cart</h1>
        {tickets.map((ticket) =>( 
            <Paper elevation={6} style={{margin:"10px",padding:"15px",textAlign:"left"}} key={ticket.id}>
              ID:{ticket.id} <br></br>
              Theatre:{ticket.theatre} <br></br>
              Movie:{ticket.movie} <br></br>
              Showtime:{ticket.showtime} <br></br>
              Seat:{ticket.seat}
            </Paper>
          ))}
      </Paper>

      <Paper elevation={3} style={paperStyle}>
        <h1>Payment</h1>
        <p>Your total is ${totalPrice}</p>

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
