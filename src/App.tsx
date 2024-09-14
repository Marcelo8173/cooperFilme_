import React from "react";
import GlobalStyles from "./Globalstyles/globalStyles";
import { AppRoutes } from "./routes/Routes";

function App() {
  return (
    <div className="App">
      <AppRoutes />
      <GlobalStyles />
    </div>
  );
}

export default App;
