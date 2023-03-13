import React from "react";
import {base} from "../../config/config"
import storage from "../../util/LocalStorageUtil";

class Home extends React.Component{
    componentDidMount() {
        console.log(storage.get('token'))
        const url=`${base}/head`
        fetch(url,{
            method: "get",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Authorization': storage.get('token')
            },
        }).then((resp)=>{
            console.log("无异常")
            console.log(resp)
        }).catch((e)=>{
            console.log("ggg")
            console.log(e)
        })
    }

    render() {
        return <h1>欢迎光临</h1>
    }
}

export default Home;