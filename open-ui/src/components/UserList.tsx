import React, {useState} from "react";
import StudentResponse from "../types/user";
import userService from "../services/user-service";


const UserList: React.FC = () => {
    const [users, setUsers] = useState<Array<StudentResponse>>([]);

    const getAllStudents = () => {
        userService.getAllUsers()
            .then((response : any) => {
                setUsers(user => [...user]);
                console.log(response.data);
            }).catch((e: Error) => {
                console.log(e);
        });
    }

    return (
        <div></div>
    );
}

export default UserList;