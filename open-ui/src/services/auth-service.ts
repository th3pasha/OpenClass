import AccountCommand from "../types/auth";
import httpCommon from "../core/http-common";
import ApiRoutes from "../core/ApiRoutes";


const register = (payload: AccountCommand) => {
    return httpCommon.post(ApiRoutes.register, payload);
}

const login = (payload: AccountCommand) => {
    return httpCommon.post(ApiRoutes.login, payload);
}

const authService = {
    register,
    login
};

export default authService;