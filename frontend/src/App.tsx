import React from 'react';
import Routing from "./router/Routing";
import GlobalStyle from "./styles/GlobalStyle";
import Footer from "./components/layout/footer/Footer";
import Header from "./components/layout/header/Header";

function App() {
  return (
      <div className="App">
          <GlobalStyle />
          <Header />
          <Routing />
          <Footer />
      </div>
  );
}

export default App;
