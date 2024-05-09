
import "./App.css";
import { BrowserRouter, Route, Routes,  } from "react-router-dom";
import Nav from "./navbar/Nav";
import SearchBook from "./Book/SearchBook";
import Borrow from "./Borrow";
function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Nav></Nav>

        <Routes>
          <Route exact path="/" element={<SearchBook></SearchBook>} />
          <Route exact path="/borrow" element={<Borrow></Borrow>} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
