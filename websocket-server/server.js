const WebSocket = require('ws');

const wss = new WebSocket.Server({ port: 8082 });

var count = 0;
var countLimit = 10000;

wss.on('connection', (ws) => {
    console.log('Client connected');

    ws.on('message', (message) => {
        console.log('Received:', message);
    });

    // Send a message to the client every second
    setInterval(() => {
        if(count === countLimit) {
            count = 0;
        }
        ws.send(`Hello from server ${count}`);
        count = count + 1;
    }, 1000);

    ws.on('close', () => {
        console.log('Client disconnected');
    });
});

console.log('WebSocket server is running on ws://localhost:8082');
