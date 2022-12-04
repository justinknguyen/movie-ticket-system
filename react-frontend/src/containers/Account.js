import * as React from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import Container from "@mui/material/Container";
import Paper from "@mui/material/Paper";
import Button from "@mui/material/Button";
import { useState, useEffect } from "react";
import { flexbox } from "@mui/system";
import { userInfo } from "./Login.js";
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import Checkbox from '@mui/material/Checkbox';
import { globalTickets } from "./Payment.js";

export default function Account() {
	const [isError, setIsError] = useState(false);
	const [isSubmitted, setIsSubmitted] = useState(false);
	const [checked, setChecked] = useState([0]);
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

	const handleDelete = (e) => {
		const id = [];
		for (var i = 0; i < checked.length; i++) {
			id.push(tickets[checked[i]].id);
		}
		console.log(id)

		for (var i = 0; i < id.length; i++) {
		fetch("http://localhost:8080/api/v1/ticket/delete/"+id[i], {
			method: "DELETE",
			headers: { "Content-Type": "application/json" }
			})
			.then(() => {
				console.log("Ticket Deleted From User");
				setIsSubmitted(true);
				setIsError(false);
				fetch("http://localhost:8080/api/v1/registereduser/tickets"+userInfo.email)
				.then(res=>res.json())
				.then(result=>{
					setTickets(sortByKey(JSON.parse(JSON.stringify(result)), "id"));
				})
			})
			.catch(() => {
				console.log("err2");
				setIsError(true);
				setIsSubmitted(false);
			})
			}
	};

	const handleToggle = (value) => () => {
		const currentIndex = checked.indexOf(value);
		const newChecked = [...checked];
		if (currentIndex === -1) {
		  newChecked.push(value);
		} else {
		  newChecked.splice(currentIndex, 1);
		}
		setChecked(newChecked);
	  };

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
			{tickets.map((ticket,i) =>(
				<ListItemButton role={undefined} onClick={handleToggle(i)} dense>
				<ListItemIcon>
					<Checkbox
					  edge="start"
					  checked={checked.indexOf(i) !== -1}
					  tabIndex={-1}
					  disableRipple
					/>
				  </ListItemIcon>
				<Paper elevation={6} style={{margin:"10px",padding:"15px",textAlign:"left"}} key={ticket.id}>
					ID:{ticket.id} <br></br>
					Theatre:{ticket.theatre} <br></br>
					Movie:{ticket.movie} <br></br>
					Showtime:{ticket.showtime} <br></br>
					Seat:{ticket.seat}
				</Paper>
				</ListItemButton>
			))}
			<br></br>
          <Box textAlign='center'>
            <Button variant="contained" onClick={handleDelete}>
              Delete
            </Button>
          </Box>
			</Paper>
		</Container>
	);
}
