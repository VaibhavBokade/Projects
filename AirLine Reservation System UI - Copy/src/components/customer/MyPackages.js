import React, { Component } from "react";
import "./Upgrade.scss";
import { CustomerDataServices } from "../../services/CustomerDataServices";
import FormControl from "@material-ui/core/FormControl";
import Select from "@material-ui/core/Select";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableContainer from "@material-ui/core/TableContainer";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import Modal from "@material-ui/core/Modal";
import Fade from "@material-ui/core/Fade";
import Radio from "@material-ui/core/Radio";
import RadioGroup from "@material-ui/core/RadioGroup";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import Paper from "@material-ui/core/Paper";
import Button from "@material-ui/core/Button";
import Pagination from "@material-ui/lab/Pagination";
import Backdrop from "@material-ui/core/Backdrop";
import CircularProgress from "@material-ui/core/CircularProgress";
import Snackbar from "@material-ui/core/Snackbar";
import CloseIcon from "@material-ui/icons/Close";
import IconButton from "@material-ui/core/IconButton";

export default class MyPackages extends Component {
  constructor() {
    super();
    this.state = {
      UserID: localStorage.getItem("CustomerID"),
      rows: [],
      PageNumber: 1,
      TotalPages: 0,
      ProductType: "all",
      //
      TicketID: 0,
      FlightID: 0,
      FlightName: "",
      Company: "",
      To: "",
      Destination: "",
      Time: "",
      PaymentType: "",
      CardNo: "",
      Upiid: "",
      Price: 0,
      Status: "",
      SeatClass: "",
      //
      OpenTicketDetailModel: false,
      //
      OpenLoader: false,
      OpenSnackBar: false,
      Message: "",
    };
  }

  componentWillMount() {
    console.log("MyPackages Component will mount calling ...");
    this.GetUserTickets(this.state.PageNumber);
  }

  GetUserTickets = (PageNumber) => {
    let data = {
      userID: this.state.UserID,
      pageNumber: PageNumber,
      numberOfRecordPerPage: 6,
    };
    CustomerDataServices.GetUserTickets(data)
      .then((data) => {
        console.log("GetUserTickets data : ", data);
        this.setState({
          rows: data.data.reverse(),
          TotalPages: data.totalPage,
        });
      })
      .catch((error) => {
        console.log("GetUserTickets Error : ", error);
      });
  };

  handleSnackBarClose = (event, reason) => {
    if (reason === "clickaway") {
      return;
    }

    this.setState({ OpenSnackBar: false });
  };

  handleCancelBooking = (TicketID) => {
    let data = {
      ticketID: TicketID,
      status: "cancelled",
    };
    CustomerDataServices.UpdateTicket(data)
      .then((data) => {
        console.log("handleCancelBooking data : ", data);
        this.setState({
          OpenLoader: false,
          OpenSnackBar: false,
          Message: data.message,
        });
        this.GetUserTickets(this.state.PageNumber);
      })
      .catch((error) => {
        console.log("handleCancelBooking Error : ", error);
        this.setState({
          OpenLoader: false,
          OpenSnackBar: false,
          Message: "Something went wrong",
        });
        this.GetUserTickets(this.state.PageNumber);
      });
  };

  handlePaging = async (e, value) => {
    console.log("Current Page : ", value);
    this.GetUserTickets(value);
  };

  handleClose = () => {
    console.log("Handle Close Calling ...");
    this.setState({
      OpenTicketDetailModel: false,
    });
  };

  handleTicketDetailModel = (data) => {
    this.setState({
      OpenTicketDetailModel: true,
      TicketID: data.ticketID,
      FlightID: data.flightID,
      FlightName: data.flightName,
      Company: data.company,
      To: data.to,
      Destination: data.destination,
      Time: data.time,
      PaymentType: data.paymentType,
      CardNo: data.cardNo,
      Upiid: data.upiid,
      Price: data.price,
      Status: data.status,
      SeatClass: data.seatClass,
      Date: data.flightDate,
    });
  };

  render() {
    let state = this.state;
    return (
      <div className="MyPackages-MainContainer">
        <div className="MyPackages-SubContainer">
          <div className="Upgrade-Container-Header">
            <div className="Upgrade-Container-Header-Part1">
              {localStorage.getItem("CustomerFullName")} Your Booking
            </div>
            <div className="Upgrade-Container-Header-Part2">
              <FormControl variant="outlined" className="" size="small">
                <Select
                  native
                  name="ProductType"
                  value={state.ProductType}
                  onChange={this.handleChange}
                >
                  <option defaultValue value="all">
                    All
                  </option>
                  <option value="plans">Plan</option>
                  <option value="device">Device</option>
                </Select>
              </FormControl>
            </div>
          </div>
          <div className="Upgrade-Container-Body">
            <TableContainer component={Paper}>
              <Table className="" aria-label="simple table">
                <TableHead
                  style={{
                    width: "100%",
                    backgroundColor: "#202020",
                  }}
                >
                  <TableRow style={{ flex: 12 }}>
                    <TableCell align="left" style={{ flex: 2, color: "white" }}>
                      Flight Name
                    </TableCell>
                    <TableCell align="left" style={{ flex: 2, color: "white" }}>
                      Company
                    </TableCell>
                    <TableCell align="left" style={{ flex: 2, color: "white" }}>
                      Source
                    </TableCell>
                    <TableCell align="left" style={{ flex: 2, color: "white" }}>
                      Destination
                    </TableCell>
                    <TableCell align="left" style={{ flex: 1, color: "white" }}>
                      Price
                    </TableCell>
                    <TableCell align="left" style={{ flex: 1, color: "white" }}>
                      Time
                    </TableCell>
                    <TableCell align="left" style={{ flex: 1, color: "white" }}>
                      Status
                    </TableCell>
                    <TableCell
                      align="right"
                      style={{ flex: 0.5, color: "white", width: 160 }}
                    ></TableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                  {Array.isArray(state.rows) &&
                    state.rows.length > 0 &&
                    state.rows.map((row) => (
                      <TableRow key={row.ticketID} style={{ flex: 12 }}>
                        <TableCell
                          align="left"
                          scope="row"
                          style={{ flex: 2 }}
                          onClick={() => {
                            this.handleTicketDetailModel(row);
                          }}
                        >
                          {row.flightName}
                        </TableCell>
                        <TableCell
                          align="left"
                          scope="row"
                          style={{ flex: 2 }}
                          onClick={() => {
                            this.handleTicketDetailModel(row);
                          }}
                        >
                          {row.company}
                        </TableCell>
                        <TableCell
                          align="left"
                          style={{ flex: 2 }}
                          onClick={() => {
                            this.handleTicketDetailModel(row);
                          }}
                        >
                          {row.to}
                        </TableCell>
                        <TableCell
                          align="left"
                          style={{ flex: 2 }}
                          onClick={() => {
                            this.handleTicketDetailModel(row);
                          }}
                        >
                          {row.destination}&nbsp;
                        </TableCell>
                        <TableCell
                          align="left"
                          style={{ flex: 1 }}
                          onClick={() => {
                            this.handleTicketDetailModel(row);
                          }}
                        >
                          {row.price}
                        </TableCell>
                        <TableCell
                          align="left"
                          style={{ flex: 1 }}
                          onClick={() => {
                            this.handleTicketDetailModel(row);
                          }}
                        >
                          {row.time}
                        </TableCell>
                        <TableCell
                          align="left"
                          style={{ flex: 1 }}
                          onClick={() => {
                            this.handleTicketDetailModel(row);
                          }}
                        >
                          {row.status}
                        </TableCell>
                        <TableCell
                          align="right"
                          style={{ flex: 0.5, width: 160 }}
                        >
                          {row.status !== "cancelled" ? (
                            <Button
                              variant="outlined"
                              color="secondary"
                              onClick={() => {
                                this.handleCancelBooking(row.ticketID);
                              }}
                            >
                              Cancel Booking
                            </Button>
                          ) : null}
                        </TableCell>
                      </TableRow>
                    ))}
                </TableBody>
              </Table>
            </TableContainer>
          </div>
          <div className="Upgrade-Container-Footer">
            <Pagination
              count={this.state.TotalPages}
              Page={this.state.PageNumber}
              onChange={this.handlePaging}
              variant="outlined"
              shape="rounded"
              color="secondary"
            />
          </div>
        </div>

        <Modal
          open={this.state.OpenTicketDetailModel}
          onClose={this.handleClose}
          closeAfterTransition
          BackdropComponent={Backdrop}
          BackdropProps={{
            timeout: 500,
          }}
          className="Model-Create-Ticket"
        >
          <Fade in={this.state.OpenTicketDetailModel}>
            <div className="Model-Create-Book-Main">
              <div className="Model-Create-Ticket-Header">
                <div className="Model-Create-Ticket-Header-Text">
                  Ticket Details
                </div>
              </div>
              <div className="Model-Create-Ticket-Body">
                <div className="Model-Create-Ticket-Body-Row">
                  Flight ID :
                  <div style={{ color: "red" }}>&nbsp;{state.FlightID}</div>
                </div>
                <div className="Model-Create-Ticket-Body-Row">
                  Flight Name :{" "}
                  <div style={{ color: "red" }}>&nbsp;{state.FlightName}</div>
                </div>
                <div className="Model-Create-Ticket-Body-Row">
                  Flight Company :{" "}
                  <div style={{ color: "red" }}>&nbsp;{state.Company}</div>
                </div>
                <div className="Model-Create-Ticket-Body-Row">
                  Flight Price :{" "}
                  <div style={{ color: "red" }}>
                    &nbsp;
                    {state.Price} &#8377;
                  </div>
                </div>
                <div className="Model-Create-Ticket-Body-Row">
                  Source : <div style={{ color: "red" }}>&nbsp;{state.To}</div>
                </div>
                <div className="Model-Create-Ticket-Body-Row">
                  Destination :&nbsp;
                  <div style={{ color: "red" }}>{state.Destination}</div>
                </div>
                <div className="Model-Create-Ticket-Body-Row">
                  Flight Date :&nbsp;{" "}
                  <div style={{ color: "red" }}>{state.Date}</div>
                </div>
                <div className="Model-Create-Ticket-Body-Row">
                  Flight Time :&nbsp;{" "}
                  <div style={{ color: "red" }}>{state.Time}</div>
                </div>
                <div className="Model-Create-Ticket-Body-Row">
                  Name :&nbsp;{" "}
                  <div style={{ color: "red" }}>
                    {localStorage.getItem("CustomerFullName")}
                  </div>
                </div>
                <div className="Model-Create-Ticket-Body-Row">
                  Email :&nbsp;{" "}
                  <div style={{ color: "red" }}>
                    {localStorage.getItem("CustomerEmail")}
                  </div>
                </div>
                <div className="Model-Create-Ticket-Body-Row">
                  Seat Class :&nbsp;
                  <div style={{ color: "red" }}>{state.SeatClass}</div>
                </div>
                <div className="Model-Create-Ticket-Body-Row">
                  Status :&nbsp;
                  <div style={{ color: "red" }}>{state.Status}</div>
                </div>
              </div>
              <div
                className="Model-Create-Ticket-Footer"
                style={{ justifyContent: "center", fontFamily: "Roboto" }}
              >
                Don't Share Your Ticket
              </div>
            </div>
          </Fade>
        </Modal>

        <Backdrop
          style={{ zIndex: "1", color: "#fff" }}
          open={this.state.OpenLoader}
          onClick={() => {
            this.setState({ OpenLoader: false });
          }}
        >
          <CircularProgress color="inherit" />
        </Backdrop>
        <Snackbar
          anchorOrigin={{
            vertical: "bottom",
            horizontal: "left",
          }}
          open={state.OpenSnackBar}
          autoHideDuration={2000}
          onClose={this.handleSnackBarClose}
          message={state.Message}
          action={
            <React.Fragment>
              <Button
                color="secondary"
                size="small"
                onClick={this.handleSnackBarClose}
              >
                UNDO
              </Button>
              <IconButton
                size="small"
                aria-label="close"
                color="inherit"
                onClick={this.handleSnackBarClose}
              >
                <CloseIcon fontSize="small" />
              </IconButton>
            </React.Fragment>
          }
        />
      </div>
    );
  }
}
