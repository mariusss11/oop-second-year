import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { fetchLoads, fetchCargo, fetchDocs } from '../services/LoadService';

const HomePageComponent = () => {

    const [loads, setLoads] = useState([])
    const [cargos, setCargo] = useState([])
    const [documents, setDocuments] = useState([])

    useEffect(() => {
        console.log("something is happenning")
        fetchLoads().then((response) => {
            console.log("Response: ", response);
            setLoads(response.data)
        }).catch(error => {
            console.error(error);
        })

        fetchCargo().then((response) => {
            setCargo(response.data)
        }).catch(error => {
            console.error(error);
        })

        fetchDocs().then((response) => {
            setDocuments(response.data)
        }).catch(error => {
            console.error(error);
        })

    }, [])


    return (

        <div>
            <h1>Hello</h1>

            <h1>Load table</h1>
            <table className="table table-hover table-bordered text-center">
                <thead className="table-dark">
                    <tr>
                        <th>LoadId</th>
                        <th>Details</th>
                        <th>Documents</th>
                    </tr>
                </thead>
                <tbody>
                    {loads.map((load) => (
                        <tr key={load.loadId}>
                            <td>{load.loadId}</td>
                            <td>{load.details}</td>
                            <td>{load.documentList && load.documentList.length > 0 ? (
                                <ul>
                                    {load.documentList.map((doc, index) => {
                                        <li key={index}>
                                            {doc.details}
                                        </li>
                                    })}
                                </ul>                                
                            ) : ( <span>No documents</span> )
                            }</td>
                        </tr>
                    ))}
                </tbody>
            </table>


            <h1>Documents table</h1>
            <table className="table table-hover table-bordered text-center">
                <thead className="table-dark">
                    <tr>
                        <th>DocumentId</th>
                        <th>Details</th>
                    </tr>
                </thead>
                <tbody>
                    {documents.map((document) => (
                        <tr key={document.documentsId}>
                            <td>{document.documentsId}</td>
                            <td>{document.details}</td>
                        </tr>
                    ))}
                </tbody>
            </table>


            <h1>Carog table</h1>
            <table className="table table-hover table-bordered text-center">
                <thead className="table-dark">
                    <tr>
                        <th>CargoId</th>
                        <th>Details</th>
                    </tr>
                </thead>
                <tbody>
                    {cargos.map((cargo) => (
                        <tr key={cargo.cargoId}>
                            <td>{cargo.cargoId}</td>
                            <td>{cargo.details}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>

    )
}

export default HomePageComponent;