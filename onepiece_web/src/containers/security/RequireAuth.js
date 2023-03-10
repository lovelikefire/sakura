import React from "react";
import { Navigate  } from 'react-router-dom'
import LocalStorageUtil from "../../util/LocalStorageUtil";
import {message} from "antd";
// 这个组件将根据登录的情况, 返回一个路由


export default function RequireAuth({ children }) {
    let storage = new LocalStorageUtil();
    const authed = storage.getItem('token')
    if (authed !=null){
        return children
    }else{
        message.warning("没有登录或身份过期，请重新登录")
        return (
            <Navigate to="/login" replace /> // 跳转到登录
        )
    }
}



