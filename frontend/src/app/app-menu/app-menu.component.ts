import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { User } from '../common/User';

@Component({
  selector: 'app-app-menu',
  templateUrl: './app-menu.component.html',
  styleUrls: ['./app-menu.component.css']
})
export class AppMenuComponent implements OnInit {

  email = '';
  pass = '';

  constructor(private authService: AuthService) { }

  ngOnInit() {
  }

  CheckLogin(){
    const user: User = new User();
    user.email = this.email;
    user.password = this.pass;
    this.authService.login(user).subscribe(response=> {
      console.log(response);
    });
  }

}
