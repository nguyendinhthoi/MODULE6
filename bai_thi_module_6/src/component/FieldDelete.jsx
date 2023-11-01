// eslint-disable-next-line no-unused-vars

import * as fieldService from "../service/FieldService.jsx"
import {toast} from "react-toastify";

function FieldDelete(props) {
    // eslint-disable-next-line react/prop-types
    let {show, handleClose, selectedField} = props;
    const handleDelete = async (field) => {
        console.log(field)
        const res = await fieldService.deleteField(field.idFootballFieldDto)
        if (res.status === 200) {
            toast("Delete Okay")
            handleClose()
        } else {
            toast.error("Delete Fail")
        }
    }
    return (
        <>
            {show && (
                <div className="modal" tabIndex="-1" style={{display: 'block'}}>
                    <div className="modal-dialog">
                        <div className="modal-content">
                            <div className="modal-header">
                                <h5 className="modal-title">Confirm Deletion</h5>
                                <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"
                                        onClick={handleClose}></button>
                            </div>
                            <div className="modal-body">
                                {/* eslint-disable-next-line react/prop-types */}
                                <p>Do you want to delete <b>{selectedField.nameFootballFieldDto}</b>?</p>
                            </div>
                            <div className="modal-footer">
                                <button type="button" className="btn btn-secondary" data-bs-dismiss="modal"
                                        onClick={handleClose}>Close
                                </button>
                                <button type="button" className="btn btn-primary"
                                        onClick={() => handleDelete(selectedField)}>Delete
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            )}
        </>
    );
}

export default FieldDelete;
