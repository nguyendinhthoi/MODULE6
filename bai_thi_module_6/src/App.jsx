
import './App.css'
import {Route, Routes} from "react-router-dom";
import FootballList from "./component/FootballList.jsx";
import {ToastContainer} from "react-toastify";
import "react-toastify/dist/ReactToastify.css"
import FootballCreate from "./component/FootballCreate.jsx";

function App() {

  return (
    <>
        <Routes>
          <Route>
            <Route path="/" element={<FootballList/>}></Route>
              <Route path="/create" element={<FootballCreate/>}></Route>
          </Route>
        </Routes>
        <ToastContainer></ToastContainer>
    </>
  )
}

export default App
