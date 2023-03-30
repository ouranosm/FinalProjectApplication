import React, { useState, useEffect } from 'react';

function UsersPage() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      const response = await fetch('http://localhost:8080/api/users');
      const data = await response.json();
      setUsers(data);
    };

    fetchData();
  }, []);

  const handleAddUser = async (username) => {
    const response = await fetch('http://localhost:8080/api/users', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({ username })
    });

    const newUser = await response.json();
    setUsers([...users, newUser]);
  };

  const handleDeleteUser = async (userId) => {
    await fetch(`http://localhost:8080/api/users/${userId}`, {
      method: 'DELETE'
    });

    const updatedUsers = users.filter(user => user.id !== userId);
    setUsers(updatedUsers);
  };

  return (
    <div>
      <h1>Users Page</h1>
      <form onSubmit={(event) => {
        event.preventDefault();
        const username = event.target.username.value;
        handleAddUser(username);
        event.target.reset();
      }}>
        <input type="text" name="username" placeholder="Enter username" />
        <button type="submit">Add User</button>
      </form>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {users.map(user => (
            <tr key={user.id}>
              <td>{user.id}</td>
              <td>{user.username}</td>
              <td>
                <button onClick={() => handleDeleteUser(user.id)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default UsersPage;
