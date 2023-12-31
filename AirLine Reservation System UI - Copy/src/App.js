import './App.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import SignUp from './components/authentication/SignUp';
import AdminDashboard from './components/admin/AdminDashboard';
import CustomerDashboard from './components/customer/CustomerDashboard';
import VendorDashboard from './components/vendor/VendorDashboard';

function App() {
  return (
    <div className="App">
      <Router>
        <Switch>
          <Route exact path="/" component={SignUp} />
          <Route exact path="/AdminDashboard" component={AdminDashboard} /> 
          <Route exact path="/CustomerDashboard" component={CustomerDashboard} />
          <Route exact path="/VendorDashboard" component={VendorDashboard} />
        </Switch>
      </Router>
    </div>
  );
}

export default App;
