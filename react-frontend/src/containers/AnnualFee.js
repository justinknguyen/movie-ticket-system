import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Container from '@mui/material/Container'
import Paper from '@mui/material/Paper'
import Button from '@mui/material/Button'
import { useState, useEffect } from 'react';
import { userInfo } from "./Login.js";
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import Checkbox from '@mui/material/Checkbox';
var totalPrice = 20.00;


export default function AnnualFee() {
  const paperStyle = {padding:'50px 20px', width:600, margin:'20px auto'}
  const [isError, setIsError] = useState(false);
  const [isSubmitted, setIsSubmitted] = useState(false);
  const [cardNo,setCardNo] = useState('')
  const [expiry,setExpiry] = useState('')
  const [cvv,setCvv] = useState('')
  const [name,setName] = useState('')
  const [price,setPrice] = useState('')

  function sortByKey(array, key) {
		return array.sort(function (a, b) {
			var x = Number(a[key]);
			var y = Number(b[key]);
			return x < y ? -1 : x > y ? 1 : 0;
		});
	}

  const handleClick=(e)=>{
    e.preventDefault()
    const creditCard={cardNo, expiry, cvv, name}
    console.log(creditCard)
    // TODO: send data to database
    fetch(`http://localhost:8080/api/v1/payment/addPayment/${cardNo}/${price}`,
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
        <h1>Annual Fee Payment</h1>
        <p>Your total is ${totalPrice}.00</p>

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
