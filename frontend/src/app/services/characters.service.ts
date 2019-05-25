import { Injectable } from '@angular/core';
import {Restangular} from 'ngx-restangular';
import { Character} from '../common/character';
import { Observable } from 'rxjs';

@Injectable()
export class CharactersService {

  charactersContext = 'characters';
  constructor(private restangular: Restangular) { }

  getAllCharacters(): Observable<Character[]> {

    const token = localStorage.getItem('id_token');

    return this.restangular.all(this.charactersContext)
      .customGET( undefined, undefined, {
        'Content-Type': 'application/json;charset=UTF-8',
        'Authorization': token ? 'Bearer ' + token : ''
      });
  }

}
