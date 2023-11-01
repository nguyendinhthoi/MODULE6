import React, {useEffect, useState} from 'react';
import {ErrorMessage, Field, Form, Formik} from "formik";
import {Link} from "react-router-dom";
import * as Yup from "yup"
import {getAllDistrict, getAllTime, getAllType} from "../service/FieldService.jsx";
function FootballCreate() {
    const [listType, setListType] = useState([]);
    const [listDistrict, setListDistrict] = useState([]);
    const [listTime, setListTime] = useState([]);
    const [timeSelect, setTimeSelect] = useState(null);
    const getListType =async () => {
        const res = await getAllType();
        setListType(res)
    };

    const getListDistrict =async () => {
        const res = await getAllDistrict();
        setListDistrict(res);
    };
    const getListTime =async () => {
        const res = await getAllTime();
        setListTime(res);
    };
    useEffect(() => {
        getListType();
        getListDistrict();
        getListTime();
    }, []);

    const formCenter = {
        marginTop: '100px',  // Add margin-top
    }
    const headingStyle = {
        fontSize: '1.5rem', // Font size for the heading
        margin: '0', // Remove margin for the heading
        letterSpacing: '1px', // Add slight letter-spacing for style
        textTransform: 'uppercase', // Uppercase the heading text
        fontWeight: 'bold', // Make the heading text bold
        color: '#a6682d', // Adjust the text color to complement the background
        textAlign: 'center'
    };
    const initialValues = {
        timeOfRentDto: "",
        nameFootballFieldTypeDto: "",
        addressFootballFieldDto: "Male",
        nameFootballFieldDto: "",
        nameDistrictDto: "",
    }
    const validationSchema = {
        // fullName: Yup.string()
        //     .required("Not Empty")
        //     .matches(/^[A-Z][a-z]+(\s[A-Z][a-z]+)+$/, "Must capitalize the first letter"),
        // dateOfBirth: Yup.string()
        //     .required("Not Empty"),
        // idCardNumber: Yup.string()
        //     .required("Not Empty")
        //     .matches(/^\d{9}|\d{12}$/, "9 or 12 numbers"),
        // phoneNumber: Yup.string()
        //     .required("Not Empty")
        //     .matches(/^(?:\(\d+\)\+)?(09[01]\d{7}|(84)\+09[01]\d{7})$/, "The phone number must be " +
        //         "in the correct format 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx"),
        // address: Yup.string()
        //     .required("Not Empty"),
        // email: Yup.string()
        //     .required("Email is required")
        //     .matches(/^[\w\-.]+@([\w-]+\.)+[\w-]{2,}$/, "Invalid email address"),
    };

    return (
        <>
            <h3 style={headingStyle}>Create Football Field</h3>
            <Formik initialValues={initialValues}  validationSchema={Yup.object(validationSchema)}
            >
                <Form className="container" style={formCenter}>
                    <div className="row">
                        <div className="col-md-6">
                            <div className="mb-3">
                                <label htmlFor="name" className="form-label">
                                    Name Football Field
                                </label>
                                <Field type="text" name="nameFootballField" className="form-control"/>
                                <ErrorMessage name="nameFootballField" component="div" className="text-danger"/>
                            </div>
                        </div>
                        <div className="col-md-6">
                            <div className="mb-3">
                                <label className="form-label">Type of football field</label>
                                <div>
                                    <Field
                                        as="select"
                                        name="footballFieldType"
                                    >
                                        {listType.map((type) => (
                                            <option key={type.idType} value={type.idType}>{type.nameType}</option>
                                        ))}
                                    </Field>
                                </div>
                            </div>
                            <div className="mb-3">
                                <label className="form-label">District of football field</label>
                                <div>
                                    <Field
                                        as="select"
                                        name="district"
                                    >
                                        {listDistrict.map((district) => (
                                            <option key={district.idDistrict} value={district.idDistrict}>{district.nameDistrict}</option>
                                        ))}
                                    </Field>
                                </div>
                            </div>
                            <div className="mb-3">
                            <label className="form-label">Time of rent</label>
                            <div>
                                <select name="time" onChange={(value)=> setTimeSelect(value.target.value)}>
                                    {listTime.map((time) => (
                                        <option key={time.idTime} value={time.price}>{time.name}</option>
                                    ))}
                                </select>
                            </div>
                        </div>
                            <div className="mb-3">
                                <label htmlFor="name" className="form-label">
                                    Price of Rent
                                </label>
                                <Field
                                    className="form-control mt-2 border border-dark"
                                    type="text"
                                    value={timeSelect}
                                    disabled
                                />
                            </div>
                        </div>
                    </div>
                    <button type="submit" className="btn btn-primary">
                        Submit
                    </button>
                    <Link to="/">
                        <button className="btn btn-primary">
                            Back to list
                        </button>
                    </Link>
                </Form>
            </Formik>
        </>

    );
}

export default FootballCreate;