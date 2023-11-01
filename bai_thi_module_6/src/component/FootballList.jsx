import React, {useEffect, useState} from "react";
import {Link} from "react-router-dom";
import * as fieldService  from "../service/FieldService.jsx";
import FieldDelete from "./FieldDelete.jsx";

export default function FootballList() {
    const [listField, setListField] = useState([]);
    const [value, setValue] = useState("");
    const [choose, setChoose] = useState("name");
    const [page, setPage] = useState(0);
    const [totalPages, setTotalPages] = useState(0);
    const [totalElements, setTotalElements] = useState(0);
    const [selectedField, setSelectedField] = useState(null);
    const [modalStatus, setModalStatus] = useState(false);
    const [listType, setListType] = useState([]);
    const [listDistrict, setListDistrict] = useState([])


    const list = async () => {
        const lists = await fieldService.getAll(choose, value, page);
        setListField(lists.content);
        setTotalPages(lists.totalPages);
        setTotalElements(lists.totalElements);
    }
    const getType =async () => {
        const listType = await fieldService.getAllType()
        setListType(listType);
    };
    useEffect(() => {
        list();
    }, [page, totalPages, totalElements,value])
    const getDistrict =async () => {
        const res = await fieldService.getAllDistrict();
        setListDistrict(res)
    };
    useEffect(() => {
        getType();
        getDistrict();
    }, []);
    const deleteModal = (p) => {
        setModalStatus(true)
        setSelectedField(p)
    };
    const closeModal = () => {
        list();
        setModalStatus(false)
        setSelectedField(null)
    }
    console.log(listType)

    return (
        <>

            <div className="container mt-5 pt-5">
                <div className="col-12 d-flex justify-content-center my-3">
                    <h1>Football Information</h1>
                </div>
                <div className="row my-3">
                    <div className="col-12 d-flex justify-content-end">
                        <div className="col-auto me-2">
                            <input type="text" onChange={(value) => setValue(value.target.value)}/>
                        </div>
                    </div>
                </div>
                <Link to={"/create"} type="button"
                      className="btn btn-outline-primary">Thêm
                    mới</Link>
                <select name="type">
                    {
                        listType.map((type,index) =>(
                            <option key={index} value={type.idType}>{type.nameType}</option>
                        ))
                    }
                </select>
                <select name="district">
                    {
                        listDistrict.map((type,index) =>(
                            <option key={index} value={type.idDistrict}>{type.nameDistrict}</option>
                        ))
                    }
                </select>

                <div style={{minHeight: "455px"}}>
                    <table className="shadow w-100" id="QuanND">
                        <thead>
                        <tr style={{background: "black", color: "white"}}>
                            <th>#</th>
                            <th>Name</th>
                            <th>Football Type</th>
                            <th>District</th>
                            <th>Address</th>
                            <th>Time of rent</th>
                            <th>Delete</th>
                        </tr>
                        </thead>

                        {listField && listField.map((p, status) =>
                            (<tr key={p.id}>
                                <td>{(status + 1) + page * 10}</td>
                                <td>{p.nameFootballFieldDto}</td>
                                <td>{p.nameFootballFieldTypeDto}</td>
                                <td>{p.nameDistrictDto}</td>
                                <td>{p.addressFootballFieldDto}</td>
                                <td>{p.timeOfRentDto}</td>
                                <td>
                                <button className="btn btn-danger" id="delete-button"  onClick={() => deleteModal(p)}>Delete</button>
                                </td>
                            </tr>)
                        )}
                        {!totalElements && (
                            <tr>
                                <td colSpan={8}>
                                    <p style={{textAlign: "center", color: "red"}}>Không tìm thấy</p>
                                </td>
                            </tr>
                        )}

                    </table>
                </div>


                <div className="row d-flex justify-content-around my-3">
                    {/*{totalPages > 1 && (*/}
                    {/*    <div className="col-auto float-end mb-3">*/}
                    {/*        <ul className="pagination mb-0">*/}
                    {/*            <li className="page-item">*/}
                    {/*                <a className={`page-link ${page === 0 ? "disabled" : ""}`}*/}
                    {/*                   onClick={() => setPage(0)} tabIndex="-1"*/}
                    {/*                   aria-disabled="true">Đầu</a>*/}
                    {/*            </li>*/}
                    {/*            <li className="page-item">*/}
                    {/*                <a className={`page-link ${page <= 0 ? "disabled" : ""}`}*/}
                    {/*                   onClick={() => setPage(page - 1)} tabIndex="-1"*/}
                    {/*                   aria-disabled="true">Trước</a>*/}
                    {/*            </li>*/}
                    {/*            <li className="page-item" aria-current="page">*/}
                    {/*                <a className="page-link" href="#">{page + 1}/{totalPages}</a>*/}
                    {/*            </li>*/}
                    {/*            <li className="page-item">*/}
                    {/*                <a className={`page-link ${page >= totalPages - 1 ? "disabled" : ""}`}*/}
                    {/*                   onClick={() => setPage(page + 1)}>Sau</a>*/}
                    {/*            </li>*/}
                    {/*            <li className="page-item">*/}
                    {/*                <a className={`page-link ${page >= totalPages - 1 ? "disabled" : ""}`}*/}
                    {/*                   onClick={() => setPage(totalPages - 1)}>Cuối</a>*/}
                    {/*            </li>*/}
                    {/*        </ul>*/}
                    {/*    </div>*/}
                    {/*)}*/}
                </div>
            </div>
            <FieldDelete
                show={modalStatus}
                selectedField={selectedField}
                handleClose={closeModal}
            ></FieldDelete>
        </>
    )
}