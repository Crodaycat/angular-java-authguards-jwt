import { baseURL } from './BaseUrl';
// Function for settting the default restangular configuration 
export function RestangularConfigFactory(RestangularProvider) {
    RestangularProvider.setBaseUrl(baseURL);
    RestangularProvider.setDefaultHeaders({ 'Access-Control-Allow-Origin': '*' });
}