import { Injectable } from '@angular/core';
import { Restangular } from 'ngx-restangular';
import { User } from '../common/User';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Observable } from 'rxjs';


@Injectable()
export class AuthService {
  loginContext = 'login';
  constructor(private restangular: Restangular) {}

  login(user: User): Observable<any> {
    return this.restangular
      .all(this.loginContext)
      .customPOST(user, undefined, undefined, {
        'Content-Type': 'application/json;charset=UTF-8'
      });
  }

  setToken(token: string) {
    localStorage.setItem('id_token', token);
  }

  getToken() {
    return localStorage.getItem('id_token');
  }

  getRoles(): string[] {
    const token = this.getToken() || '';
    const helper = new JwtHelperService();
    const payload = helper.decodeToken(token);
    return payload ? payload.roles : [];
  }
}
