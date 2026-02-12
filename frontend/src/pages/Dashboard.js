import { useEffect, useState } from "react";
import api from "../services/api";
import { useNavigate } from "react-router-dom";

function Dashboard() {
  const [data, setData] = useState({});
  const navigate = useNavigate();

  useEffect(() => {
    api.get("/dashboard")
      .then(res => setData(res.data))
      .catch(() => navigate("/"));
  }, []);

  const logout = () => {
    localStorage.removeItem("token");
    navigate("/");
  };

  return (
    <div>
      <div className="navbar">
        <h2>College Student Management</h2>
        <button className="button-danger" onClick={logout}>
          Logout
        </button>
      </div>

      <div className="dashboard-container">
        <div className="cards">

          <div className="card">
            <h3>Total Students</h3>
            <p>{data.totalStudents}</p>
          </div>

          <div className="card">
            <h3>Fees Collected</h3>
            <p>₹ {data.totalFeesCollected}</p>
          </div>

          <div className="card">
            <h3>Fees Pending</h3>
            <p>₹ {data.totalFeesPending}</p>
          </div>

          <div className="card">
            <h3>Total Marks Entries</h3>
            <p>{data.totalMarksEntries}</p>
          </div>

        </div>

        <br />
        <button
          className="button-primary"
          onClick={() => navigate("/students")}
        >
          View Students
        </button>
      </div>
    </div>
  );
}

export default Dashboard;
