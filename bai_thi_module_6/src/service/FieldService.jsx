import axios from "axios";
export const getAllTime =async () => {
    try {
        const res = await axios.get(`http://localhost:8080/time`)
        return res.data;
    } catch (e) {
        alert("Access Denied");
    }
};
export const getAllDistrict =async () => {
    try {
        const res = await axios.get(`http://localhost:8080/district`)
        return res.data;
    } catch (e) {
        alert("Access Denied");
    }
};


export const getAllType = async () => {
    try {
        const res = await axios.get(`http://localhost:8080/type`)
        return res.data;
    } catch (e) {
        alert("Access Denied");
    }
};


export const deleteField =async (id) => {
    try {
        const res = await axios.post(`http://localhost:8080/delete/${id}`)
        console.log(res.status)
        return res;
    } catch (e) {
        alert("Access Denied");
    }
};


export const getAll =async (choose, value, page) => {
    try {
        const result = (await axios.get(`http://localhost:8080/list?searchName=${value}&page=${page}`)).data
        return result;
    }catch (error){
        console.log(error)
    }
};