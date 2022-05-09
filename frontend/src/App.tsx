import React from 'react';
import Routing from "./Routing";
import GlobalStyle from "./styles/GlobalStyle";
import Footer from "./components/layout/footer/Footer";

function App() {
  return (
      <div className="App">
          <GlobalStyle />
          <Routing />
          <Footer />
      </div>
  );
}

export default App;
