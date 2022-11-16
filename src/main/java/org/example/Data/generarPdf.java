package org.example.Data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itextpdf.html2pdf.HtmlConverter;

import org.example.Models.Producto;
import org.example.Conector.Conector;

public class generarPdf {

    public static Conector conectar = new Conector();
    public static Producto producto = new Producto();
    public static String sql;
    public static PreparedStatement ps;
    public static String HTMlRender;

    public static Connection con = conectar.getConexion();
    public static void Pdf() throws IOException {

        //obtener datos par generar el pdf
        try{
            sql = "SELECT * FROM producto";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            System.out.println("se obtienen datos de la DB: ");

            while(rs.next()){

                System.out.println("*******************************");
                System.out.println("id: "+rs.getInt("id"));
                System.out.println("nombre: "+rs.getString("nombre"));

                HTMlRender = "Factura: "+rs.getString("nombre")+"<hr>" +
                        "<img src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAT8AAAEBCAYAAAAO1qJ2AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAABz7SURBVHhe7d2/bhrL2wfwx+9VYCkpkFLGDVVASmMpFxCQj2SojlKms9zZceHgznKXMkoFkWJBLiCSmyNBKhp+ZSQKR8J3se88u4OBZf/PzjK78/1InBhzWNsL+zCzO/OdA0cgAADL/J/8FwDAKih+AGAlFD8AsBKKHwBYybri9/S9QwcHB1u3zvcn+ai66ed8twcAetjZ8rueEF/kXt1GpzX5AADYAt1ev983W63Cm9/y+8+mdLPx+ME/Q+J23qpF2boiGncP149/nnpPc5/XoeFfeVfYaiXyz+Vt/R1SZ+e57ImG/8jv803+XADIBsVviyhQv47XrcJpny6bN+K7K1zAWjQbLtf/z48ucbuxdjpy70+uidqbj39qek9N4r5Hhy8XdM7PexxQ++r2uVg+ff9KdCe36SxpQD36iO41QGZ2Fr+r1roFJW7r1l2TLjaL1Ztj6tOMFs8F6JYuTwb0RVs3uU2DxwvxWwgvjqlzMn7+2bXTC+q+8L4W9+j4fZvGfxbyPgCkFV78Nrtf7m2zBST4uof+bhh36TYf37oIoHPb/u6huO10XX3n/C7eyO8L29tu0aX8Plv8GRMd1d2WnhYnHTreKHDdHxu/m2+fHXbF77JJ5z5T2jaAocTBb5XlsO2I4ifvbXMfo76zfnTi9KntDB69e1HPXRHdXkd0e+W9TdvbYlv/77Tv0MnACXqm99zt7Sb5XQAgHM75+Z3UqS6/nH7ebvnV3naoLbrMuxdB1uqvRHf058NWy2ht3Y3lCyR8cSSNRl22OUUr8KO/5QcAqaD4baidnlOfLzrI7tvtqwGJFtfaiy6NHgc0a25083xdwNrpF/dixGob6yu2TbpwL6B43z/8c+5eHEmmSR+G7efnHrxcUEfcB4DskOoCAFZCyw8ArITiBwBWQvEDACuh+AGAlQKL3//+9z/5VXoqz2U2/mzV3xsA0kPLDwCshOIHAFZC8QMAK6H4wTq4YCs/cGUVerCdRfhsFbjgm+nyLHLbK/JnRP4/APlC8QOiNxdeRuC8FVCAvHQZZ9qg3suAAshT/hyHJkc9OgwqgJHbBtgfFD+QZJELC191i9hoI1NwW/OTeK4Mdt0Vs22p/WoVKQGgH4ofGMArjlhLBYqE4gcAVkLxAwArofhZorRR8zER+gBZofhZwr0gsbFuSWnOr7kXWjZ+99CLKgDpoPhVSaIxdVUTMw4RIASKH5Sct4zn5vooAEmg+FXJqouYZqH0CqjVG+K/baqHjEEECILiByU2pRvu5jdnNHgMH4ANEATFz3jyAA+7WT1lrEkX7oUQf+HDPoN4KH7GWx3gITfLurjJYJ9BPBQ/ALBS4Lq9HKv++vVreS8dlecCABQFLT8AsBKKHwBYCcUPAKyE4lc4bxjGTrCAlVPT9inhtDj3dcHUuSpC8TMF4t4LFhPPD5WH4rcnjXpQNkmyuHfIUUw8v6eBqXMVhKEuAGAltPwAwEoofgBgJRS/PK0W8H6+3RAuXVTV6mrx+nbzWz4EpYBzfgBgJXNbfjHj3lYL8gR/2uqMNkdsOiSk9B4G3cwtfm+Oqc//zhei3KSlM9ocsemQj+Y79x1OswXWo9sHg8/51al+Iv45qotys2u1GtnFG/kNH53R5ohNh0TilhV4URfvorAxn6CbkcXv6XtHdAcOqXc0yTDgV2e0OWLTIQ/y1MnLHjWm4R/goBlf8PCbz+fyq/SinztxREOfL7AE364n8v/TYZ8/GyCZyXXAe/P51hfvYsgLrvYCgJUwzg8ArJR78UOrDwDKAC0/ALASih8AWAnFDwCslFPx88YtbU7T4bF6O1HtpbL7N7nTlf4ZZphxApCeN951NxwjclrcKlwD79NY+RS/31+pRwP6sDFYs3Z6To3uYWnnLU4/e4Ostwagvvkg/soRPWBaG+yRO7vpcUCzZkABfNGlkePQ5KhHhyiAkXIZ58efRA/vAkaq86fQywWdOxdUqmB2buGJX3gS8Hvzp/Hhn3NEzYN27nvtZ4eWP7qBUzxBjXrxiylwXBhvXy1pdFqWl4+7u4e0OAubdsRT3G6pjultAKWm3O2dfusRDT+Etuw4uWL886E8ze+/DzS679Nx6HzLJh1fj2n0HzoUAGWmWPym9HDVps7biFYdJ1fcL2gh7xrv74LGJ3Wqy7tBmv8OiLpfd05EA0B5KBW/p++3dHl9Ht39E8WvQbPSZN89LWbyqwgvjqlzckkPJb2YAzZbhfGub2W9KKlKofg90cPPMfXfxZz4Fy2pWYnWPfWy+uLUqHvWp8s7XE2DspFrQ3POoLzZGqmVvfgFDG8JlKAbaZSk3XROmr7HsBeoIEvGCmYuftNfl9R+fxx7CT7p/2cM2aW9jR2g3aQPQ6LeN5z5AyijbENdko7fq+A4v20Y9gJQVrkMcg7GhaEl/innOQUen9iiLDH6AFAGikNdwvGV4NlwWdqTqc1PSxrMW9ZeCQOoOo0tPwAAc2lr+QEAmCyw5QcAUHVo+QGAlVD8AMBKKH4AYKVkxS8mvt2N2/5cjZkOavH7PLZxN3YcoCwiI/JlKEJVhn/FX/BwZ2mMqBM2iyHxbIiyUBucjfRdKD33mO9RI+gY4OP913ElBv/HFD8v1Xj0PiyJudyzOEIpTssrX3o1QFLVmdIZXfy4yt/VQ1sxVV7PQqmAlXVOM0ACVTnuI8/5RSeyJMzzKyml+H2EnUKF1d52qH31UPpz2xHF74kWc6JGPazls6DFfbs0IaWpKcXv16h+RDRbVDkNDaz1okvn10li38wWUfy4uMkvg7gJzRWmGL9ff9Wm8Z9spRPAdKVbmCxARPGrU/1EfhnELQ4Vphi/v/gzpvar0uRXA6TjLuDfo68lPrUTUfzium5cHMelWZgoNaX4/bhTBgBlV6Pj9226/FXeM3/xV3ub4WP4qjymDVd7AeKUe9gLxvkFwTg/gETKPOwlpvgJbiHADI+kMMMDoBziix+zaLAz/y0f6UvGVhsXzgc6RncXwHjJih8AQMVEzvAAAKiqwOLHCxgBAFQZWn4AYCUUPwCwEoofAFgpY/GLj7PmISPZ4+ALwkN4IuL5Y6k+H6BseNxv2HueHyvRMg6BQ134gsfr16/lvRB84EfGWRs++yNu8HYsb/bL4qxis1sAYvAMphZNAo99fuzhXTmOiezd3jfH1L+6pWFosEGTLh4HNGua+EkgCtdZj2j4JfucxL8PNKIBfUDhA8s0Py1pMG8F9vw46uryrhy9IYVzfk36MCTqfYsobaaGHv7+Sj1RuL4ozL2dfhPFMzTlGqDKatQ9CylyJYq6UrrgkSTO2sTQw+h4/gREl/n2qk/nCC4AW3HP735EDzs9v/JEXald7U3SslOKg9dBPWvv6b8Rja+PMX8XLBae51k7PY85JWYGteInxLbsFOPg8xcTzx9rSl+7RIN/UfrAZlFhx006vh7T6D+T+nu7lItfbB9fMQ4+fzHx/HF+P9DlSYeOjfl7APYhugfV/HdA1P1q9LAX9eIX18dXioPXQWVltSca3l1S/wxZfWC7mNUbS7B8aw7FL7qPr3xxQQO3q57lU4mHt9z36RjDW8B2sT2giCvChsil+HEfP3DYi6lXRbmrLj6V0g7BcYe3DD/gQgdYLmEPyPBhL9lneMSq+gwPADtFzfAok5xafruevt/SbLg0d5rLiy6Npg3qnXnNcp6LfHBwEHLrGH/ZHqAQ3JubD2hZgSUrNLb8AADMpa3lBwBgMhQ/ALASih8AWAnFDwCspLf48XASJB0DgIHQ8tOIx0NtRfnjw2APvCUXDj6bH7Hk5w2/MjkW3tu3UctZbNo5HvYMxU+XoNktHAF21KPDEh6IADtkKHDSNHM37MCgbE8UP0048y9oKlxUBDjo035lTrRGKkaFgmzjefupQj447MCg6W56BzlzN++M6MsP21JQeGrfLdXDps7x4k93dVpat1+gMvjYfrmgc+ci3Vx3g977aPlpwFP7Lq/Pw+cMh0aAA5RD5pAPg977KH65e6KHn2Pqv4t6W4RHgAOYb0oPV23qvM3Sdkuw8FlBUPzylugksEqgKsB+xfZsYiRZ+KwIKH45Sxbeqr6IEsB+JOnZxDBkSVsUvzwFDW8JFBMBDlbgcW8cmVaqK/8ph7eEMWFJWxS/HCVe0hKLIIHABYCV6fRHbstSGJDyjOKXm6RLWmIRJJB4TWvxT2lOfyTu2SSx/zU+MM6vYFWJAAcVPC3skHr3RH1Tl3mwAFp+ReJPzopEgIMK0er54RC3O1D49gcx9gBgJbT8AMBKKH4AYCUUPwCwEoofAFgJxQ8ArKSn+PH4voMDOgiJbDctzjot8+PF7VLu1yNdFHzR8j1WOecy4nXiulHgMg96it+LLo0chyYc2R7wx5gWZ+3nHUwdGiJyCjSbfj6k3tHEzPF+uc7oYBxnNaNWWIEreJkHrd3e5ieHnKDZHYbFWW8RL/jHnx1aThvUO4v4FDI4XtxKZXw9ft9QSxSXiaGD3sOWYlBROx25jaKPIa3JQpd54EHOfvP5XH6l0bTv0MnAWcq7pphck9Ofrr9uD037DaEals7gZP1eM8/E6VPbGTzKu3l6HDht6oufEKKg2rC/Cx4GRrlzd5fn3a66IM1PE2p0D7HYEOTv7wON7vt0bOj0NtXA0kjc8zu5pIew46qg2rDHq73mxFmvcJN8O3CgSReYfwk6/F3Q2Niueg6BpZHiksyLWeZhj8VP7AJD4qwBiva0mMmvDJRTYGmU+qs2jf8s5D2/YpZ52GvxMyXOGqBotXpDfmWe3AJLIyz+jCPWUi5mmYf9Fj/BhDhrgMJxkOn9gsLaPnuT+/CWIHHFrZhlHvZe/EyIswYonDzpb1qvJ/FSDCriLvYUtMyDGXl+Bq3iDlAYft+LKjNxLvQWm8R4BsYt1R9Heq7ySjxr5PbVkkaBrUsv5Xpxpv9CI8JMAfbItmUNeDjZIU8iCGnoFLk/9t/tBbBYoTMa9o4X+WrQJKyHx+cbC1zmAS0/ALASWn4AYKXcix+3GgEATIeWHwBYCcUPAKxkcPHj8T4IFAUAPdDyMxUPgN1IvC179H8+zI58T4zj2iOWefC/9nuT9+/B25MJ6btLD3ivbZEJ6ih+RhJvhLtL6p+tx0OZHv1fiALSRgoRs8yDN+Vzz1mXXKCbMxrcFTXrqkbdHw45nKD+spgCiOJnIp776D/ITY7+LwinjWx+IJRd6DIP4jvH7/eZdSk+fM96RMMv+U5z4zAHariBBW6qTVCe4ZsLchy90+tWUPwMNP0m3ng7kULik/GsT5d3BnSH9kGmjZiafJy32uk59a9u93POW7awv+Sd7OK2eOU8Zi5ye57Lj+JnmqhIIQOj/4vifiDkvJiO2Zp0fD2m0X/Ff9QVkednAhQ/w0RHCpkX/V+MKT1ctanztuqH4zb3PG/3a8FJ58UEiZoAxc8oPPGbaPBvePvGxuh/rYvpmCxuoR8tOEhUfllxKH4mSRLiaF30v+7FdEy2j/O8vHiQ/LLiUPyMsTu8JUzW6H8eK3hwULJxckYPb4kZm+aOaxOPf1Zopxd+nreYxYNMgOJnijTruGaM/ueiycr0xjb75DsPSWmLf0OWWeTCxf/OFwott+LP87ofroWfayweip8h0l3NzNgdcsdZlehkdtSVb0N4q7CFLbYju5BHdaXiXfiwF/5wNXB9kdxxmKnffD6XX6Wn8txtS2dw0nYGj/IuKOB9SRxa6/Sn8lugaOKIVp3Yp8Hv0eWw7e5vup7I75TM48Bph/xtVYGWXxFWczlDbvrn7MqpQ47+RWHs0aQLsT/DZiPUTkfu/i7t2hw8IJmnmp1Vd1B97jH2iMAHgDJAyw8ArGRc8UMMPgAUAS0/ALASih8AWAnFr3A8KwDx/H48+6SUCc08i0NlBgfsTfmKnztsZDP+GlbTrPQUD53bVhQzfSx6Ol/M1LTV8KQi4uRTvqd1Lmlg03IJ5St+cmJ/UNLF7roAHvcgMGFNBG3kjI9fOj4SdG5bkZv6u6TBvBVYAN2k5McBzZpBBVCOfQyLTY+Lms9R2qxCnUsaWLVcAo/z89vnDI9Ez5/2HToZOEt5d82bydAebjxi3Eh1XTNXeMaBrr9T57Y9k+uSzj7h96LSLA7et33x3zS897me/aVz22Yp5zm/0In9Xitlc1I2f6qOrciC0zkB3tYQVf28rMKw8NowsjWuJepK57bNUtILHl6aRmBXbHNStjsxvh0ZDlolOoNObQxR1S8+vDaUzqgrS5ZLKO3V3vCkC/HJdefFf99Y0+qTdAadWheiWoAk4bWh0NJXVdrixy9Q6AIv8kC9vOrTpKwTyzPKGnSahM5t2+cpcXhtGLT01ZS4+ImDMWKBl/qrdvC6oFWXMeg0EZ3btk2a8NowaOkrKXXxy7zAS5FjuAoXcT5Umc5t2yWvpTjR0s+u3MWPz+9luTLlFk3x7/2CFt53KkVn8u9eF9OujByX4kRLP7OSFz8h5AVywyRDV4T3FmmpbrcYJ8NNlu9SnBj2klX5ix+/QD9SJBTLKVGt+YCWocWx/Nzir+lij85t2yD3/cczXXS9l3Vue88qUPxScqdEOZV9QcFe3vRObz7z7g1hGn7GxdgjBh8AimBfyw8AQKhU8UMEPgAkhZYfAFgJxQ8ArITiBwBWsq74RUebe8MF8orxNiYSXGf0v85tM96+8dMQp3Rj5FASg5cgMAEPdfEzPsk5ROLnuunOYWm1nKybQ5Kt+zPSJvTqozMpWXcKM29fLS1Zp4D0cEOYvd/2z87iFyeHwrUcts06IEKj/3Ogc9suc6PV+XVO/7frWspgA78mWd7DyrH85YHiF4I/NbMXL/1rXqRX8nUftBfYLBReZ7c4mfh6eM81b1/nDxc8QqjE+eQ7cT0vJY+6MjFaXSWJmadZypXlcj8vrJQV6M2Vd1etq/gSsSh+YV7UqZ0p8uqJHn6Oqf/OvIn/5Y66qlP9ZEwLg4rf02JGdFTPPkf8BS+POaFG9zDfhc//LmismFjEy34uhzNqVXhOMIpfGFH8GjRLf7D9/ko9GtAHlYRebSKi/5Xp3DbzYshmC3Ou+y7+jOVXOcjxg8MtyrkZVza+DMUvjPj0nInyV0/ZpZn+uqT2++PsrQHNoqL/VencNreoF3OiRt2cPesulaDCHSbUotlwSY4zyu00Sa3ekF9lx8O0DrsNmvB1gYrGl6H4hcnSdRBv5turPp2fGhyWlTX6Pwmd26YFLe7bqT+MdHKLzHyRbQwiF76XPWpMHRrl/X7JfMrGw4XPzbt0LpRj9o0mL3xswdXebFd73WEPZRgmoPPKqa5tG3u1N8tVVd1DXbwrtplGK/B+xlCXbCpR/DKN8zNxeEsYnUNTdGxb5++rJts4vwK4Q2nMGWRvokqFmeYThMpTlVrinxTR+KCV2w2jiaHnnngK2SGN3i/z774qMnu/7R/O+fnwGD0+Ae0vfPxG2o0GX92qPR5qr/g8Kp9/MvYA5nFxPFzlo3FDQpqfljSYtzC3NwRafgBgJbT8AMBKKH4buOWY1b6ey1SfD2AjFD8AsBKKHwBYCcUPQMXvm3xDCfJSigTs/ULxA+8ATnigcMx/qoM9xbZT/b+lYnCcfGX3eTwUPyB684EGlCArTxwo7mT3NGPukm6bWyrNGQ3uusaGQmRmbNKPKMp3l9Q/q+A+TwDFDwQOI6WY6KIp3TTFgTJNO9k9ybbFQXjWIxp+MSwANh+c9GNkgeHQU2Pj1/RD8QNXXBipl049yTTlLzboVLaMvpichpOVTPrJlqqs1/Sb+MAxOH5NNxQ/kKLCSFXTqaODTk3PQFThFpjhB/OioWRRNjp+TTMUP3gWHkaqnqUXvm3zQkrzM6WHqzZ13pr3tz39N6Lx9XG18/pioPjBWlgYqZtqrSg06JQLq/yyYsxcyIpN6WuXaPCvzaUPxQ+21Kh71qfLO9/QB3c9E1Uh23YXJpJfVoq5C1kprTpXISh+sC1wicicVk4L3LZ5CxPlAsNbjIfiBz5N+jD0D02R6/LutNrSCtq2+C6vkaxt4aP9MPYijtKavtWC4gc7goamuN+779FXxVkKgcNeeCD0ySXd5r14974YfCXV2KvPe4DiBwGadLGzlKL43rRPl03V1Oqgbdeoe8dXg81LQ87EXYzczJXPeDFy0+L29wXFD5J7c+Gt4q9jIj8XjGmDemd2zjOF4qH4QSq105G+BXFEcXV+lOxEPP/OJq4vwh8mZduXBUPxAwArGbeAEQBAEdDyAwArofgBgJVQ/ADASih+FnEj6A8MjVNPRCEOPjauXSVqfko3Bx0zxyhyQvZBxrGZmiPup58PqJNpYLvKa7VmZPHjncIH6eYtzwM2+043lPsG395flfr7VrLOl+X9ExeRn3kuLh+ILZoZmkKdeUZHkn2mQmEWzPTzIfWOsgXrbuGrvX7z+Vx+lZ7Kc1cm1+S0h0t5L3+6t1+4x4HTprYzeAy5XxH8uvWn8k5iS2dwEv96Z9u22Pqw7dDJQPwUE02cPvXFf9NKts9U8H7LtP1p36FMf9OucnZ7uTm+0crZbRVyN2SjJSSb7qtuX+uKaNw9XD++mrGw08z3dWdWj2+2tLZmO3jN8eftauwyRHKz8zZTWDb3R3D3bLVvVretfepvWW7+zbxPxP3N52tpdcqWQuoJ+Uki8rNuW+xXNxfP0EWXvDzBDIGl2pcV8PZb+pBXcXxxIk3qdWSClbD4iQP51zG3WL3bznxTPtC5G7Jc/z9ypLs7O0HcF5/yJD511o+nGaF/36PDlws65+c9Dqi9MUn/6ftXoju5TWcp3j49+riP7udOcgfPp+XfaUJ9+Z0t4uD/yKuyrfaHuK27FGJ/vuxRY7p6TGzjqrVd4MT9wz/n3uPi9dCR0JK1+5YkXSVz19DoXLzsgaW6E2kyh7zmnEhjbPHbaplttVbEgbxZrDgjjmbPrRx3x57o/NRq0+BRfvL4Wli104uNF9SLgRr/Wcj7uo2p91LuL7dYpf10DEpZXu/P9bkwL+Bg/PNh3aoVjy9Xr4nv9chH1jj4JBH52aPmnxYzoqO6ka2+7IVZ97ICCiGvfxc0PqlTXd5VZWzx22qZ+VJAti+ItMRhu7b4M9b7htx6Q9Wo+2OjleTrHh52xe+SmK/LLG7pLvJwUV63zqiZovvphgpwC1r+bH93fc8HePY4+PiI/Ozblu81I8nuYabAUs3LCiiEvLofNjkqXbeXzy21rvobXbTtrlz9VVt+VTSve0gbRXs5TPO7eIV09Vy+Zb+axaGhKVudPEFf/tzJkejabxbA+WKrGOb9JoymEgcfF5GvFjW/v/daDKXuod5lBVS61LW6+mIKm8p5wWOj6Tv9vN3yq73tUPuqFdlq4jftVrdt07345HO/8IYwbG47iefugnsebV8tAz7fk89B7e7PrRBTue2iYtAVWgr8gRIZka+0bXkw+j4YTKAWWKpxWQF5YSlzyOuLungvro7PHIhP+h1mD3Xhy/fEYQzurT0ciPu+YR3uUI/1/7M7FMG7lP/8+PX6wjn/7NX3+1P+WRvb5svsEcMa3GEPq21S3xnw/Y1ta+P/e8Vta/+5wwO2Hxfd5Oe/a/v35ptvKIFv+zvb3tonvn2mKPq9kEDE0Ajlbcv3YpYhMvrksP9zHE6yyX2fKR0P+Q7BMbL4Abjcoqt6EIYcMLlsWx7QBo3zUy8wTMc4v5w+FHMszIi0gurjC1EvR9R59Mfn54FPjxzS6P2yWvHwWveZGr7g2aKJcohsOc/5gfWCpkCub765rCkj8v0Dvrdv/kHifKFqQo0SrD+ic58p8Y2S8N/8oxaan5Y0mEef108CLT8AsBJafgBgpcCWHwBA1aHlBwBWQvEDACuh+AGAlVD8AMBKKH4AYCUUPwCwEoofAFgJxQ8ArITiBwAWIvp/5QHslRpfWmgAAAAASUVORK5CYII=\" /><hr>" +
                        "* Daniel Arango Villegas <br>" +
                        "* Sistema de notificacion y factura <br>" +
                        "* https://github.com/daniel-990 <hr>" +
                        "<table>\n" +
                        "  <tr>\n" +
                        "    <th>Nombre</th>\n" +
                        "    <th>Precio</th>\n" +
                        "    <th>descripcion</th>\n" +
                        "    <th>categoria</th>\n" +
                        "  </tr>\n" +
                        "  <tr>\n" +
                        "    <td>"+rs.getString("nombre")+"</td>\n" +
                        "    <td>"+rs.getInt("precio")+"</td>\n" +
                        "    <td>"+rs.getString("descripcion")+"</td>\n" +
                        "    <td>"+rs.getString("categoria")+"</td>\n" +
                        "  </tr>\n" +
                        "</table>";

                HtmlConverter.convertToPdf(HTMlRender, new FileOutputStream("_pdf/producto_"+rs.getInt("id")+".pdf"));
                System.out.println( "El PDF ["+rs.getInt("id")+"] se creo con exito" );

            }
            //se obtiene un dato - el ultimo
            //HtmlConverter.convertToPdf(HTMlRender, new FileOutputStream("final.pdf"));
            //System.out.println( "El PDF se creo con exito" );

        }catch (Exception e){
            System.out.println("Error al obtener datos: "+e.getMessage());
        }

    }

}
