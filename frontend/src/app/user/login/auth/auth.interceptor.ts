import {HttpInterceptorFn} from '@angular/common/http';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
  // Ajoute withCredentials: true à chaque requête HTTP
  const cloned = req.clone({
    withCredentials: true
  });
  return next(cloned);
};
