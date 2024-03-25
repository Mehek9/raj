import { Component, OnInit, Renderer2 } from '@angular/core';

@Component({
  selector: 'app-chatgpt',
  templateUrl: './chatgpt.component.html',
  styleUrls: ['./chatgpt.component.css']
})
export class ChatgptComponent implements OnInit {

    constructor(private renderer: Renderer2) { }
  
    ngOnInit(): void {
      this.loadScript();
    }
  
    private loadScript() {
      const script = this.renderer.createElement('script');
      script.src = 'https://s3.ap-south-1.amazonaws.com/conferbot.defaults/dist/v1/widget.min.js';
      script.async = true;
      script.charset = 'UTF-8';
      script.onload = () => {
        // Initialize the chat bot widget with custom configurations
        (window as any).ConferbotWidget("YOUR_CHATBOT_ID", "conferbot-chat-widget", {
          font: 'Arial',
          fontSize: 14,
          hideLogo: false,
          logo: 'https://conbot-test.s3.ap-south-1.amazonaws.com/642d634620a83e213dcb962f/chat-logo-1681732018335.png',
          logoText: 'Conferbot Support',
          // Add other customization options here
        });
      };
      this.renderer.appendChild(document.body, script);
    }
  }
  

