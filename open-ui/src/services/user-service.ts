import httpCommon from "../core/http-common";
import ApiRoutes from "../core/ApiRoutes";
import StudentResponse from "../types/user";
import StudentCommand from "../types/user";


const getAllUsers = () => {
    return httpCommon.get<StudentResponse>(ApiRoutes.users);
}
const updateInfo = (id: string, payload: StudentCommand) => {
    return httpCommon.put(ApiRoutes.users +`/${id}`, payload);
}
const deleteUser = (id: string, payload: StudentCommand) => {
    return httpCommon.delete(ApiRoutes.users +`/${id}`);
}

const userService = {
    getAllUsers,
    updateInfo,
    deleteUser
}

export default userService;