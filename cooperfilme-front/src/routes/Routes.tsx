import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { Authprovider } from "../hooks/AuthContext";
import { Home } from "../pages/home/Home";
import { Login } from "../pages/Login/Login";
import { NewScript } from "../pages/NewScript/NewScript";

import PrivateRoute from "../routes/Private.routes";
import { Dashboard } from "../pages/Dashboard/Dashboard";
import { ScriptsDetails } from "../pages/ScriptsDetails/ScriptsDetails";

const AppRoutes: React.FC = () => {
  return (
    <Authprovider>
      <Router>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/newScript" element={<NewScript />} />
          <Route path="/dashboard" element={<PrivateRoute />}>
            <Route path="" element={<Dashboard />} />
          </Route>
          <Route path="/scripts/details/:id" element={<PrivateRoute />}>
            <Route path="" element={<ScriptsDetails />} />
          </Route>
        </Routes>
      </Router>
    </Authprovider>
  );
};

export { AppRoutes };


