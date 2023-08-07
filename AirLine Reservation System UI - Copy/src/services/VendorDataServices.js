const baseURL = "http://localhost:8080";

export const VendorDataServices = {
  InsertFlightDetails,
  GetFlightDetails,
  UpdateFlightDetails,
  DeleteFlightDetails,
};

function InsertFlightDetails(reqbody) {
  // debugger;
  const requestOptions = {
    method: "POST",
    headers: {
      "content-type": "application/json",
      "cache-control": "no-cache",
      Authorization: `Bearer ${localStorage.getItem("VendorToken")}`,
    },
    body: JSON.stringify(reqbody),
  };
  return fetch(baseURL + `/api/Vendor/InsertFlightDetails`, requestOptions)
    .then((res) => res.json())
    .then((result) => {
      return result;
    });
}

function GetFlightDetails(reqbody) {
  const requestOptions = {
    method: "POST",
    headers: {
      "content-type": "application/json",
      "cache-control": "no-cache",
      Authorization: `Bearer ${localStorage.getItem("VendorToken")}`,
    },
    body: JSON.stringify(reqbody),
  };
  return fetch(baseURL + `/api/Vendor/GetFlightDetails`, requestOptions)
    .then((res) => res.json())
    .then((result) => {
      return result;
    });
}

function UpdateFlightDetails(reqbody) {
  const requestOptions = {
    method: "PUT",
    headers: {
      "content-type": "application/json",
      "cache-control": "no-cache",
      Authorization: `Bearer ${localStorage.getItem("VendorToken")}`,
    },
    body: JSON.stringify(reqbody),
  };
  return fetch(baseURL + `/api/Vendor/UpdateFlightDetails`, requestOptions)
    .then((res) => res.json())
    .then((result) => {
      return result;
    });
}

function DeleteFlightDetails(reqbody) {
  const requestOptions = {
    method: "DELETE",
    headers: {
      "content-type": "application/json",
      "cache-control": "no-cache",
      Authorization: `Bearer ${localStorage.getItem("VendorToken")}`,
    },
    body: JSON.stringify(reqbody),
  };
  return fetch(baseURL + `/api/Vendor/DeleteFlightDetails`, requestOptions)
    .then((res) => res.json())
    .then((result) => {
      return result;
    });
}
