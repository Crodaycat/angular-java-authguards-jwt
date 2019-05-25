import { Injectable } from '@angular/core';
import { Restangular } from 'ngx-restangular';
import { User } from '../common/User';
import { Observable } from 'rxjs';

@Injectable()
export class AuthService {
  loginContext: string = 'login';
  constructor(private restangular: Restangular) {}

  login(user: User): Observable<any> {
    return this.restangular
      .all(this.loginContext)
      .customPOST(user, undefined, undefined, {
        'Content-Type': 'application/json;charset=UTF-8'
      });
  }
}
