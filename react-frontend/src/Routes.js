import React from "react";
import { Route, Routes } from "react-router-dom";

import NotFound from "./containers/NotFound";
import Login from "./containers/Login";
import Home from "./containers/Home";

export default function Links() {
  return (
    <Routes>
        <Route path="/movie-ticket-system/" element={<Home />} />
        <Route path="/movie-ticket-system/login" element={<Login />} />
        
        {
          /* Finally, catch all unmatched routes */
        }
        <Route path="*" element={<NotFound />} />;
    </Routes>
  );
}