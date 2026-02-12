import { useEffect, useState } from "react";
import api from "../services/api";
import { useNavigate } from "react-router-dom";

function Students() {

  const [students, setStudents] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    api.get("/students")
      .then(res => setStudents(res.data))
      .catch(() => navigate("/"));
  }, []);

  return (
    <div>
      <div className="navbar">
        <h2>Students</h2>
        <button
          className="button-primary"
          onClick={() => navigate("/dashboard")}
        >
          Back
        </button>
      </div>

      <div className="dashboard-container">

        <table style={{
          width: "100%",
          borderCollapse: "collapse",
          background: "white",
          borderRadius: "10px",
          overflow: "hidden"
        }}>

          <thead style={{ background: "#2c3e50", color: "white" }}>
            <tr>
              <th style={thStyle}>ID</th>
              <th style={thStyle}>Name</th>
              <th style={thStyle}>Roll No</th>
              <th style={thStyle}>Department</th>
              <th style={thStyle}>Year</th>
              <th style={thStyle}>Email</th>
              <th style={thStyle}>Phone</th>
            </tr>
          </thead>

          <tbody>
            {students.map(student => (
              <tr key={student.id} style={{ textAlign: "center" }}>
                <td style={tdStyle}>{student.id}</td>
                <td style={tdStyle}>{student.name}</td>
                <td style={tdStyle}>{student.rollNumber}</td>
                <td style={tdStyle}>{student.department}</td>
                <td style={tdStyle}>{student.year}</td>
                <td style={tdStyle}>{student.email}</td>
                <td style={tdStyle}>{student.phone}</td>
              </tr>
            ))}
          </tbody>

        </table>

      </div>
    </div>
  );
}

const thStyle = {
  padding: "12px",
  fontSize: "14px"
};

const tdStyle = {
  padding: "10px",
  borderBottom: "1px solid #ddd",
  fontSize: "13px"
};

export default Students;
