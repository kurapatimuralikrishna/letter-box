import axios from "axios";

const MOVIES_API_BASE_URL = "http://localhost:8080/letterbox/movies";
class EmployeeService{
    getAllMovies(){
        return axios.get(MOVIES_API_BASE_URL);
    }
}

export default new EmployeeService();