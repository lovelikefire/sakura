import React, {useState} from "react";
import {Button, Form, Input, message} from "antd";
import {base} from "../../config/config"
import {Card} from 'antd';
import '../../my.css';
import LocalStorageUtil from "../../util/LocalStorageUtil";
import {useNavigate} from "react-router-dom";

function Login() {
    const navigate = useNavigate()
    const [info, setInfo] = useState('');

    function login(value) {
        const url = `${base}/login`
        fetch(url, {
            method: "post",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(value),
        }).then((resp) => {
            resp.json().then((respJson) => {
                if (respJson.status !== 200 && respJson.status !== 201) {
                    if (respJson.code !== 200) {
                        message.error('登录失败!');
                        setInfo(respJson.msg)
                    } else {
                        setInfo('')
                        LocalStorageUtil.set("token", respJson.data)
                        navigate('/home')
                    }
                }
            })
        }).catch((e) => {
            message.error('登录失败!');
        })
    }


    return (
        <div className="login">
            <h1 className="loginTitle">ONEPIECE</h1>
            <Card title="用户登录" className="loginCard" bordered={false} style={{width: 300}}>
                <Form
                    name="basic"
                    labelCol={{span: 8}}
                    wrapperCol={{span: 16}}
                    style={{maxWidth: 600}}
                    initialValues={{remember: true}}
                    autoComplete="off"
                    onFinish={login}
                >
                    <Form.Item
                        label="Username"
                        name="username"
                        rules={[{required: true, message: 'Please input your username!'}]}
                    >
                        <Input/>
                    </Form.Item>

                    <Form.Item
                        label="Password"
                        name="password"
                        rules={[{required: true, message: 'Please input your password!'}]}
                    >
                        <Input.Password/>
                    </Form.Item>

                    <p className="errorInfo">{info}</p>
                    <Form.Item wrapperCol={{offset: 8, span: 16}}>
                        <Button type="primary" htmlType="submit">
                            登录
                        </Button>
                    </Form.Item>
                </Form>
            </Card>
        </div>
    );

}


export default Login;