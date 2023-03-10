import './App.css';
import {Route, Routes} from "react-router-dom";
import Home from "../src/containers/home/Home"
import Login from "./containers/login/Login";
import RequireAuth from "./containers/security/RequireAuth";

function App() {
    return (
        <Routes>
            <Route path="/login" element={<Login/>}/>
            <Route path="/home" element={<RequireAuth><Home/></RequireAuth>}/>
            <Route path="/" element={<RequireAuth><Home/></RequireAuth>}/>
        </Routes>
    );
}

export default App;


