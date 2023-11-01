import './App.css'
import {Route, Routes} from "react-router-dom";
import Login from "./components/Login.jsx";
import Header from "./components/Header.jsx";
import {Nav} from "react-bootstrap";
import Footer from "./components/Footer.jsx";
import Home from "./components/Home.jsx";

function App() {

  return (
      <>
        <Routes>
          <Route path="/" element={<Home/>}></Route>
          <Route path="/login" element={<Login/>}></Route>
            <Route path="/test" element={<Header/>}></Route>
            <Route path="/test1" element={<Footer/>}></Route>
        </Routes>
      </>
  )
}

export default App
