import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { Authprovider } from "../hooks/AuthContext";
import { Home } from "../pages/home/Home";
import { Login } from "../pages/Login/Login";

// import PrivateRoute from "../routes/Private.routes";

const AppRoutes: React.FC = () => {
  return (
    <Authprovider>
      <Router>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          {/* <Route path="/dashboard" element={<PrivateRoute />}>
            <Route path="" element={<Dashboard />} />
          </Route> */}
        </Routes>
      </Router>
    </Authprovider>
  );
};

export { AppRoutes };
