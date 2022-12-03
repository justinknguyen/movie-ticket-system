import * as React from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import Container from "@mui/material/Container";
import Paper from "@mui/material/Paper";
import Button from "@mui/material/Button";
import { useState, useEffect } from "react";
import { flexbox } from "@mui/system";
import { userInfo } from "./Login.js";
import { globalTickets } from "./Payment.js";

export default function Account() {
	const [tickets,setTickets] = useState([])

	const paperStyle = {
		padding: "50px 20px",
		width: 600,
		margin: "20px auto",
	};

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

	return (
		<Container>
			<Paper elevation={3} style={paperStyle}>
			<h1>Account Information</h1>
				<Paper elevation={6} style={{margin:"10px",padding:"15px",textAlign:"left"}} >
					ID:{userInfo.id} <br></br>
					Email Address:{userInfo.email} <br></br>
					Password:{userInfo.password} <br></br>
					Name:{userInfo.name} <br></br>
					Address:{userInfo.address} <br></br>
					Date Registered:{userInfo.dateRegistered} <br></br>
				</Paper>
			</Paper>

			<Paper elevation={3} style={paperStyle}>
			<h1>Tickets</h1>
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
		</Container>
	);
}
