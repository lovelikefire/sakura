import React from "react";
import {base} from "../../config/config";
import {message} from "antd";
import LocalStorageUtil from "../../util/LocalStorageUtil";

class Home extends React.Component{
    componentDidMount() {
        const url = `${base}/head`
        fetch(url, {
            method: "get",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Authorization' : LocalStorageUtil.get("token")
            },
        }).then((resp) => {
            resp.json().then((respJson) => {
                console.log(respJson.data)
            })
        }).catch((e) => {
            message.error('登录失败!');
        })
    }

    render() {
        return <h1>欢迎光临</h1>
    }
}

export default Home;