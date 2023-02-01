import React, {ChangeEvent, useState} from "react";
import AccountCommand from "../types/auth";
import authService from "../services/auth-service";
import {FormControl} from 'baseui/form-control';
import {Input} from 'baseui/input';

const Register: React.FC = () => {
    const initAccount = {
        email: "",
        password: ""
    };

    const [account, setAccount] = useState<AccountCommand>(initAccount);
    const [submitted, setSubmitted] = useState<boolean>(false);

    const handleInputChange = (event: ChangeEvent<HTMLInputElement>) => {
        const { name, value } = event.target;
        setAccount({ ...account, [name]: value });
    };
    const register = () => {
        const data = {
            email: account.email,
            password: account.password
        };
        authService.register(data)
            .then((response : any ) => {
                setAccount({
                    email: response.data.email,
                    password: response.data.password
                });
                setSubmitted(true);
            }).catch((e: Error) => {
                console.log(e);
        });
    };
    const newAccount = () => {
        setAccount(initAccount);
        setSubmitted(true);
    }

    return (
        <React.Fragment>
            <FormControl label="Input label" caption="Input caption">
                <Input />
            </FormControl>
            <FormControl
                positive="Positive caption"
                label="Input label"
                caption="Input caption"
            >
                <Input positive />
            </FormControl>
            <FormControl
                error="Error caption"
                label="Input label"
                caption="Input caption"
            >
                <Input error />
            </FormControl>
        </React.Fragment>
    );
}

export default Register;