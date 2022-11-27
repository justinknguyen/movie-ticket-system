import React from "react";
import { Route, Routes } from "react-router-dom";

import NotFound from "./containers/NotFound";
import Home from "./containers/Home";
import Login from "./containers/Login";
import Signup from "./containers/Signup";
import Theatres from "./containers/Theatres";
import Movies from "./containers/Movies";
import Showtimes from "./containers/Showtimes";
import Seats from "./containers/Seats";
import Seats2 from "./containers/Seats2";
import Payment from "./containers/Payment";

export default function Links() {
  return (
    <Routes>
        {/* <Route path="/movie-ticket-system/" element={<Home />} /> */}
        <Route path="/movie-ticket-system/login" element={<Login />} />
        <Route path="/movie-ticket-system/signup" element={<Signup />} />
        <Route path="/movie-ticket-system/" element={<Theatres />} />
        <Route path="/movie-ticket-system/movies" element={<Movies />} />
        <Route path="/movie-ticket-system/showtimes" element={<Showtimes />} />
        <Route path="/movie-ticket-system/seats" element={<Seats2 />} />
        <Route path="/movie-ticket-system/payment" element={<Payment />} />
        {
          /* Finally, catch all unmatched routes */
        }
        <Route path="*" element={<NotFound />} />;
    </Routes>
  );
}