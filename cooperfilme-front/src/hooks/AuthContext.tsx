import React, { createContext, useCallback, useState, useContext } from "react";
import api from "../services/api";
import { jwtDecode } from "jwt-decode";

interface User {
  email: string;
  avatar_url?: string;
  role: string;
  userId?: string;
}

interface AuthState {
  token: string;
  user: User;
}

interface singInCredentias {
  email: string;
  role: string;
  token: string;
}

interface AuthContextData {
  user: User;
  singIn(credentias: singInCredentias): Promise<void>;
  singOut(): void;
  updateUser(user: User): void;
}

const AuthContext = createContext<AuthContextData>({} as AuthContextData);

interface AuthproviderProps {
  children: React.ReactNode;
}

export const Authprovider = ({ children }: AuthproviderProps) => {
  const [data, setData] = useState<AuthState>(() => {
    const token = localStorage.getItem("@cooperFilmes: token");
    const user = localStorage.getItem("@cooperFilmes: user");

    if (token && user) {
      api.defaults.headers.authorization = `Bearer ${token}`;

      return { token, user: JSON.parse(user) };
    }

    return {} as AuthState;
  });

  interface DataToLoginProps {
    email: string;
    role: string;
    id: string;
    token: string;
  }

  const decodeToken = (token: any) => {
    try {
      const decoded = jwtDecode(token) as any;
      console.log(token, decoded);
      return decoded.userId;
    } catch (error) {
      console.error("Failed to decode token:", error);
      return null;
    }
  };

  const singIn = useCallback(
    async ({ email, role, token }: DataToLoginProps) => {
      let user: any = {
        email,
        role,
      };

      if (!token) {
        return;
      }

      const userId = decodeToken(token);
      console.log("userId", userId);
      user = {
        ...user,
        userId: userId,
      };

      localStorage.setItem("@cooperFilmes: token", token);
      localStorage.setItem("@cooperFilmes: user", JSON.stringify(user));

      api.defaults.headers.authorization = `Bearer ${token}`;

      setData({ token, user });
    },
    []
  );

  const singOut = useCallback(() => {
    localStorage.removeItem("@cooperFilmes: token");
    localStorage.removeItem("@cooperFilmes: user");

    setData({} as AuthState);
  }, []);

  const updateUser = useCallback(
    (user: User) => {
      localStorage.setItem("@cooperFilmes: user", JSON.stringify(user));
      setData({
        token: data.token,
        user,
      });
    },
    [setData, data.token]
  );

  return (
    <AuthContext.Provider
      value={{ user: data.user, singIn, singOut, updateUser }}
    >
      {children}
    </AuthContext.Provider>
  );
};

export function useAuth(): AuthContextData {
  const context = useContext(AuthContext);

  if (!context) {
    throw new Error("useAuth must be used within an AuthProvider");
  }

  return context;
}
