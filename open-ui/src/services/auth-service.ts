import AccountCommand from "../types/auth";
import http from "../core/http-common";
import ApiRoutes from "../core/ApiRoutes";


const register = (payload: AccountCommand) => {
    console.log(payload);
    return http.post<AccountCommand>(ApiRoutes.register, payload);
}

const login = (payload: AccountCommand) => {
    return http.post(ApiRoutes.login, payload);
}

const authService = {
    register,
    login
};

export default authService;