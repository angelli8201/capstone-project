import React, { useState, useEffect } from 'react';
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Modal from 'react-bootstrap/Modal'; 
import Button from 'react-bootstrap/Button'; 

function Blog() {
  const [blogs, setBlogs] = useState([]);
  const [comments, setComments] = useState({});
  const [showAddPostModal, setShowAddPostModal] = useState(false); 
  const [newPost, setNewPost] = useState({
    title: '',
    author: '',
    description: '',
    datePosted: '',
  });

  const fetchBlogs = async () => {
    try {
      const response = await fetch("http://localhost:8080/api/blog");
      if (response.ok) {
        const blogsData = await response.json();
        setBlogs(blogsData);
      } else {
        setBlogs([]);
      }
    } catch (error) {
      console.error("Error fetching blogs:", error);
    }
  };

  useEffect(() => {
    fetchBlogs(); 
  }, []);

  useEffect(() => {
    const currentDate = new Date();
    const formattedDate = currentDate.toISOString().split('T')[0];
    setNewPost((prevNewPost) => ({ ...prevNewPost, datePosted: formattedDate }));
  }, []);

  useEffect(() => {
    const savedComments = JSON.parse(localStorage.getItem('comments'));
    if (savedComments) {
      setComments(savedComments);
    }
  }, []);

  const handleAddComment = (blogId, comment) => {
    const blogComments = comments[blogId] || [];
    blogComments.push(comment);

   
    setComments({ ...comments, [blogId]: blogComments });
    localStorage.setItem('comments', JSON.stringify({ ...comments, [blogId]: blogComments }));
  };
  

  
  const handleAddPost = async () => {
    try {
      const response = await fetch("http://localhost:8080/api/blog", {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(newPost),
      });
      if (response.ok) {
        setShowAddPostModal(false);
        setNewPost({
          title: '',
          author: '',
          description: '',
          datePosted: '',
        });
        fetchBlogs();
      } else {
        console.error("Error adding a new post.");
      }
    } catch (error) {
      console.error("Error adding a new post:", error);
    }
  };

  return (
    <div className="container">
      <Button onClick={() => setShowAddPostModal(true)} className = 'mb-3'>Add Post</Button>
      <Modal show={showAddPostModal} onHide={() => setShowAddPostModal(false)}>
        <Modal.Header closeButton>
          <Modal.Title>Add a New Post</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <form>
            <div className="form-group">
            <label>Title</label>
              <input
                type="text"
                className="form-control"
                value={newPost.title}
                onChange={(e) => setNewPost({ ...newPost, title: e.target.value })}
              />
            </div>
            <div className="form-group">
              <label>Author</label>
              <input
                type="text"
                className="form-control"
                value={newPost.author}
                onChange={(e) => setNewPost({ ...newPost, author: e.target.value })}
              />
            </div>
            
            <div className="form-group">
              <label>Description</label>
              <textarea
                className="form-control"
                value={newPost.description}
                onChange={(e) => setNewPost({ ...newPost, description: e.target.value })}
              />
            </div>
         
          </form>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={() => setShowAddPostModal(false)}>
            Close
          </Button>
          <Button variant="primary" onClick={handleAddPost}>
            Add Post
          </Button>
        </Modal.Footer>
      </Modal>
      {blogs.map((blog) => (
        <Row key={blog.blogId} style={{ marginBottom: '20px' }}>
          <Card style={{ width: '100%', height: '100%' }}>
            <Card.Body>
              <Card.Title style={{ fontSize: '24px' }}>{blog.title}</Card.Title>
              <Card.Text style={{ fontSize: '16px' }}>By: {blog.author}, {blog.datePosted}</Card.Text>
              <Card.Text style={{ fontSize: '22px' }}>{blog.description}</Card.Text>

              <div>
                <h5>Comments:</h5>
                <ul>
                  {comments[blog.blogId] &&
                    comments[blog.blogId].map((comment, index) => (
                      <li key={index}>{comment}</li>
                    ))}
                </ul>
                <input
                  type="text"
                  placeholder="Add a comment"
                  onKeyUp={(e) => {
                    if (e.key === 'Enter') {
                      handleAddComment(blog.blogId, e.target.value);
                      e.target.value = '';
                    }
                  }}
                />
              </div>
            </Card.Body>
          </Card>
        </Row>
      ))}
    </div>
  );
}

export default Blog;


