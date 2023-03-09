import './App.css';
import {Route, Routes} from "react-router-dom";
import Home from "../src/containers/home/Home"
import Login from "./containers/login/Login";

function App() {
    return (
        <Routes>
            <Route path="/login" element={<Login/>}/>
            <Route path="/" element={<Home/>}/>
        </Routes>
    );
}

export default App;
